package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;
import jjtraveler.util.*;

public class UtilTest extends VisitorTestCase {

    public UtilTest(String test) {
	super(test);
    }

    public void testASTToGraph() throws jjtraveler.VisitFailure {
	DotGraph g = new DotGraph();
	Visitor v = new ASTToGraph(g);
	v.visit(n0);
	String expected = "digraph name {\n";
	expected += "Node-4 -> Node-3;\n";
	expected += "Node-4 -> Node-2;\n";
	expected += "Node-3 -> Node-0;\n";
	expected += "Node-3 -> Node-1;\n";
	expected += "}\n";
	assertEquals(expected,g.printGraph("name"));
    }

    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.test.UtilTest.class);
	return suite;
    }

}
