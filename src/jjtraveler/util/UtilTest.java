package jjtraveler.util;

import junit.framework.*;
import jjtraveler.*;
import jjtraveler.test.VisitorTestCase;

public class UtilTest extends VisitorTestCase {

    public UtilTest(String test) {
	super(test);
    }

    public void testASTToGraph() throws jjtraveler.VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor v = new ASTToGraph(g);
	v.visit(n0);
	EdgesGraph expected = new EdgesGraph();
	expected.addEdge(n0, n1);
	expected.addEdge(n0, n2);
	expected.addEdge(n1, n11);
	expected.addEdge(n1, n12);
	assertEquals(expected,g);
    }

    public void testToStringVisitor() throws VisitFailure {
	assertEquals(n0.toString(),ToStringVisitor.doToString(n0));
    }

    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.util.UtilTest.class);
	return suite;
    }

}
