package jjtraveler;
import junit.framework.*;
import jjtraveler.test.*;

public class DoWhileSuccessTest extends VisitorTestCase {

    public DoWhileSuccessTest(String test) {
        super(test);
    }

    public void testDoWhileSuccess() throws VisitFailure {
	Visitor condition = new FailAtNodes(n1, n2);
	Visitor action = new Identity();

        Logger expected = new Logger();
	expected.log( new Event( condition, n0 ));
	expected.log( new Event( action, n0 ));
	expected.log( new Event( condition, n1 ));
	expected.log( new Event( condition, n2) );

        Visitable nodeReturned = 
	    new DoWhileSuccess ( logVisitor(condition),
				 logVisitor(action) 
				 ). visit(n0);

        assertEquals(expected, logger);
        assertEquals(n0, nodeReturned);
    }
}
