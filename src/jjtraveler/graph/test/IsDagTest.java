package jjtraveler.graph.test;

import jjtraveler.graph.*;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.test.VisitorTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class IsDagTest extends VisitorTestCase {

    public void testTree() throws VisitFailure {
	Visitable node = (new IsDag()).visit(n0);
	assertEquals(n0,node);
    }

    public void testDiamond() throws VisitFailure {
	Visitable node = null;
	node = (new IsDag()).visit(rootOfDiamond);
	assertEquals(rootOfDiamond,node);
    }

    public void testCircle() throws VisitFailure {
	Visitable node = null;
	try {
	    node = (new IsDag()).visit(rootOfCircle);
	    fail("VisitFailure should have occured");
	} catch (VisitFailure vf) {
	    assertNull(node);
	}
    }

    public IsDagTest(String test) {
        super(test);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(jjtraveler.util.test.UtilTest.class);
        return suite;
    }

}
