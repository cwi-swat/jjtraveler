package jjtraveler;
import junit.framework.*;
import jjtraveler.test.*;

public class TopDownCutOffTest extends VisitorTestCase {

    public TopDownCutOffTest(String test) {
        super(test);
    }

    public void testTopDownCutOff() throws VisitFailure {
	Visitor stopAt = new Not (new FailAtNodes(n1, n2) );

        Identity id = new Identity();
        Logger expected = new Logger();
	expected.log( new Event( stopAt, n0 ));
	expected.log( new Event( stopAt, n1 ));
	expected.log( new Event( id, n1 ));
	expected.log( new Event( stopAt, n2) );
	expected.log( new Event( id, n2));

        Visitable nodeReturned = 
	    new TopDownCutOff( logVisitor(stopAt), logVisitor(id) ). visit(n0);

        assertEquals(expected, logger);
        assertEquals(n0, nodeReturned);
    }
}
