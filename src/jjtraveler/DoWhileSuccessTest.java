package jjtraveler;
import jjtraveler.test.Event;
import jjtraveler.test.FailAtNodes;
import jjtraveler.test.Logger;
import jjtraveler.test.SucceedAtNodes;
import jjtraveler.test.VisitorTestCase;

public class DoWhileSuccessTest extends VisitorTestCase {

	public DoWhileSuccessTest(String test) {
		super(test);
	}

	public void testDoWhileSuccess() throws VisitFailure {
		Visitor condition = new FailAtNodes(n1, n2);
		Visitor action = new Identity();

		Logger expected = new Logger();
		expected.log(new Event(condition, n0));
		expected.log(new Event(action, n0));
		expected.log(new Event(condition, n1));
		expected.log(new Event(condition, n2));

		Visitable nodeReturned =
			new DoWhileSuccess(
				logVisitor(condition),
				logVisitor(action)).visit(
				n0);

		assertEquals(expected, logger);
		assertEquals(n0, nodeReturned);
	}

	public void testTopDownUntil() throws VisitFailure {
		Visitor stopAt = new SucceedAtNodes(n1, n2);

		Logger expected = new Logger();
		expected.log(new Event(stopAt, n0));
		expected.log(new Event(stopAt, n1));
		expected.log(new Event(stopAt, n2));

		Visitable nodeReturned =
			DoWhileSuccess.TopDownUntil(logVisitor(stopAt)).visit(n0);

		assertEquals(expected, logger);
		assertEquals(n0, nodeReturned);
	}

	public void testTopDownUntilAtBorder() throws VisitFailure {
		Visitor stopAt = new SucceedAtNodes(n1, n2);

		Logger expected = new Logger();


		Visitor borderAction = new Identity();
		
		expected.log(new Event(stopAt, n0));
		expected.log(new Event(stopAt, n1));
		expected.log(new Event(borderAction, n1));
		expected.log(new Event(stopAt, n2));
		expected.log(new Event(borderAction, n2));

		Visitable nodeReturned = 
			new TopDownUntil(logVisitor(stopAt),
							 logVisitor(borderAction)
			).visit(n0);

		assertEquals(expected, logger);
		assertEquals(n0, nodeReturned);
	}

}
