package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;

public class FailTest extends VisitorTestCase {

    public FailTest(String test) {
	super(test);
    }

    public void testFail() {
	try {
	    (new Fail()).visit(n0);
	    fail();
	}
	catch(VisitFailure vf) {
	    Logger expected = new Logger();
	    assertEquals(expected, logger);
	}
    }

}
