package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;

public class OneTest extends VisitorTestCase {

    public OneTest(String test) {
	super(test);
    }

    public void testOne() {
	Identity id = new Identity();
	One     one = new One(logVisitor(id));
	Logger expected = new Logger(id, new Visitable[]{n1});
	try {
	    Visitable nodeReturned = one.visit(n0);
	    assertEquals(expected, logger);
	    assertEquals(n0, nodeReturned);
	} catch (VisitFailure vf) {
	    assertEquals(expected, logger);
	    //	    assertEquals(n0, nodeReturned);
	    fail("VisitFailure should not occur!");
	}
    }

}
