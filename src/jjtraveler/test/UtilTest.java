package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;
import jjtraveler.util.*;

public class UtilTest extends TestCase {

    public UtilTest(String test) {
	super(test);
    }

    Node n0;    //          4
    Node n1;    //         / \
    Node n2;    //        3   2
    Node n3;    //       / \
    Node n4;    //      0   1

    Logger logger;

    protected void setUp() {
	Node.reset();
	Node[] empty = {};
	logger = new Logger();
	n0 = Node.factory(empty,logger);
	n1 = Node.factory(empty,logger);
	n2 = Node.factory(empty,logger);
	n3 = Node.factory(new Node[]{n0,n1},logger);
	n4 = Node.factory(new Node[]{n3,n2},logger);
    }

    public void testASTToGraph() throws jjtraveler.VisitFailure {
	DotGraph g = new DotGraph();
	Visitor v = new ASTToGraph(g);
	v.visit(n4);
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
