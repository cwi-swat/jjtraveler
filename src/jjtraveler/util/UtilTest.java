package jjtraveler.util;

import junit.framework.*;
import jjtraveler.*;
import jjtraveler.test.VisitorTestCase;

public class UtilTest extends VisitorTestCase {

    public UtilTest(String test) {
	super(test);
    }

    public void testToStringVisitor() throws VisitFailure {
	assertEquals(n0.toString(),ToStringVisitor.doToString(n0));
    }
    public void testToATermString() throws VisitFailure {
	assertEquals("Node(Node(Node,Node),Node)",
		     ToATermString.doToString(n0));
    }
    public void testToXMLString() throws VisitFailure {
	assertEquals("<Node><Node><Node/> <Node/></Node> <Node/></Node>",
		     ToXMLString.doToString(n0));
    }

    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.util.UtilTest.class);
	return suite;
    }

}
