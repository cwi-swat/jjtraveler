package jjtraveler.util;

import junit.framework.*;
import jjtraveler.*;
import jjtraveler.test.VisitorTestCase;
import jjtraveler.test.*;

public class ToGraphTest extends VisitorTestCase {

    public ToGraphTest(String test) {
	super(test);
    }

    public void testToGraphIdentity() throws jjtraveler.VisitFailure {
	DotGraph g = new DotGraph();
	Visitor v = new ToGraph(g, new Identity());
	v.visit(n0);
	DotGraph expected = new DotGraph();
	expected.addEdge(n1, n11);
	expected.addEdge(n1, n12);
	expected.addEdge(n0, n1);
	expected.addEdge(n0, n2);
	assertEquals(expected.printGraph("name"),g.printGraph("name"));
    }

    public void testToGraphFail() throws jjtraveler.VisitFailure {
	DotGraph g = new DotGraph();
	Visitor v = new ToGraph(g, new Fail());
	v.visit(n0);
	DotGraph expected = new DotGraph();
	assertEquals(expected.printGraph("name"),g.printGraph("name"));
    }

    public void notestToGraphSelective() throws jjtraveler.VisitFailure {
	DotGraph g = new DotGraph();
	Visitor select = new FailAtNodes(n1,n2);
	Visitor v = new ToGraph(g, logVisitor(select));
	v.visit(n0);
	Logger expectedLogger = new Logger();
	expectedLogger.log(new Event(select,n0));
	DotGraph expected = new DotGraph();
	//	expected.addEdge(n0, n11);
	//	expected.addEdge(n0, n12);
	//assertEquals(expected.printGraph("name"),g.printGraph("name"));
	assertEquals(expectedLogger,logger);
    }

    public void testToGraphNoRoot() throws jjtraveler.VisitFailure {
	DotGraph g = new DotGraph();
	Visitor select = new FailAtNodes(n0,n0);
	Visitor v = new ToGraph(g, logVisitor(select));
	v.visit(n0);
	Logger expectedLogger = new Logger();
	expectedLogger.log(new Event(select,n0));
	expectedLogger.log(new Event(select,n1));
	expectedLogger.log(new Event(select,n11));
	expectedLogger.log(new Event(select,n11));
	expectedLogger.log(new Event(select,n12));
	expectedLogger.log(new Event(select,n12));
	expectedLogger.log(new Event(select,n2));
	DotGraph expected = new DotGraph();
	expected.addEdge(n1, n11);
	expected.addEdge(n1, n12);
	assertEquals(expected.printGraph("name"),g.printGraph("name"));
	assertEquals(expectedLogger,logger);
    }

    public void testToGraphNoLeaves() throws jjtraveler.VisitFailure {
	DotGraph g = new DotGraph();
	java.util.Set leaves = new java.util.HashSet();
	leaves.add(n11); leaves.add(n12); leaves.add(n2);
	Visitor select = new FailAtNodes(leaves);
	Visitor v = new ToGraph(g, logVisitor(select));
	v.visit(n0);
	Logger expectedLogger = new Logger();
	expectedLogger.log(new Event(select,n0));
	expectedLogger.log(new Event(select,n1));
	expectedLogger.log(new Event(select,n1));
	expectedLogger.log(new Event(select,n11));
	expectedLogger.log(new Event(select,n12));
	expectedLogger.log(new Event(select,n2));
	DotGraph expected = new DotGraph();
	expected.addEdge(n0, n1);
	assertEquals(expected.printGraph("name"),g.printGraph("name"));
	assertEquals(expectedLogger,logger);
    }

    public void testMkEdgeFromParent()
      throws VisitFailure {
	DotGraph g = new DotGraph();
	Visitor v = new MkEdgeFromParent(n0,g);
	v.visit(n1);
	DotGraph expectedGraph = new DotGraph();
	expectedGraph.addEdge(n0,n1);
	assertEquals(expectedGraph.printGraph("name"), g.printGraph("name"));
    }

    public void testMkEdgesToKids()
      throws VisitFailure {
	DotGraph g = new DotGraph();
	Visitor v = new MkEdgesToKids(g);
	v.visit(n0);
	DotGraph expectedGraph = new DotGraph();
	expectedGraph.addEdge(n0,n1);
	expectedGraph.addEdge(n0,n2);
	assertEquals(expectedGraph.printGraph("name"), g.printGraph("name"));
    }

    public void testMkEdgesToKidsSelective()
      throws VisitFailure {
	DotGraph g = new DotGraph();
	Visitor v = new MkEdgesToKids(g, new FailAtNodes(n1,n2));
	v.visit(n0);
	DotGraph expectedGraph = new DotGraph();
	expectedGraph.addEdge(n0,n11);
	expectedGraph.addEdge(n0,n12);
	assertEquals(expectedGraph.printGraph("name"), g.printGraph("name"));
    }

}
