package jjtraveler.graph;

import junit.framework.*;
import jjtraveler.*;
import jjtraveler.test.*;

public class VisitedTest extends VisitorTestCase {

    public void testSingleVisit() {
	Visitor v = new Visited();
	Visitable result = null;
	try {
	    result = v.visit(n0);
	    fail("Visit failure should have occured");
	} catch (VisitFailure vf) {
	    assertNull(result);
	}
    }

    public void testDoubleVisit() throws VisitFailure {
	Visitor v = new Visited();
	Visitable result = null;
	try {
	    result = v.visit(n0);
	    fail("Visit failure should have occured");
	} catch (VisitFailure vf) {
	    result = v.visit(n0);
	    assertEquals(result,n0);
	}
    }

    public VisitedTest(String test) {
        super(test);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(jjtraveler.util.UtilTest.class);
        return suite;
    }

}
