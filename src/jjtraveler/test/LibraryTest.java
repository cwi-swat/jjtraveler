package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;
import java.util.*;


public class LibraryTest extends TestCase 
{

    Node n0;    //          4
    Node n1;    //         / \
    Node n2;    //        3   2
    Node n3;    //       / \
    Node n4;    //      0   1

    Logger logger;

    public LibraryTest(String test) {
	super(test);
    }

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

    public void testIdentity() throws VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, new Visitable[]{n0} );
	Visitable nodeReturned = logVisitor(id).visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
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

    public void testSequence() throws VisitFailure {
	Identity id1 = new Identity();
	Identity id2 = new Identity();

	Logger expected = new Logger();
	expected.log( Event.makeVisitEvent(id1, n0) );
	expected.log( Event.makeVisitEvent(id2, n0) );

	Sequence  ls = new Sequence( logVisitor(id1), logVisitor(id2) );

	Visitable nodeReturned = ls.visit(n0);

	assertEquals(expected, logger);
	assertEquals(nodeReturned, n0);
    }

    public void testLeftChoice() throws VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, new Visitable[]{n0} );

	Choice  ch = new Choice( logVisitor(id), new Identity() );

	Visitable nodeReturned = ch.visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
    }


    public void testRightChoice() throws VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, new Visitable[]{n0} );

	Choice  ch = new Choice( new Fail(), logVisitor(id) );

	Visitable nodeReturned = ch.visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
    }


    public void testAll() throws jjtraveler.VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, new Visitable[]{n3, n2} );

	All  all = new All( logVisitor(id) );

	Visitable nodeReturned = all.visit(n4);
	assertEquals(expected, logger);
	assertEquals(n4, nodeReturned);
    }

    public void testBottomUp() throws jjtraveler.VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, new Visitable[]{n0, n1, n3, n2, n4} );

	BottomUp  visitor = new BottomUp( logVisitor(id) );

	Visitable nodeReturned = visitor.visit(n4);
	assertEquals(expected, logger);
	assertEquals(n4, nodeReturned);
    }

    public void testTopDown() throws jjtraveler.VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, new Visitable[]{n4, n3, n0, n1, n2} );

	Visitor  visitor = new TopDown( logVisitor(id) );

	Visitable nodeReturned = visitor.visit(n4);
	assertEquals(expected, logger);
	assertEquals(n4, nodeReturned);
    }

    public void testDownUp() throws jjtraveler.VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, 
	   new Visitable[]{n4, n3, n0, n0, n1, n1, n3, n2, n2, n4 } );

	Visitor  visitor = new DownUp( logVisitor(id), logVisitor(id) );

	Visitable nodeReturned = visitor.visit(n4);
	assertEquals(expected, logger);
	assertEquals(n4, nodeReturned);
    }

    public void testStopDownUp() throws jjtraveler.VisitFailure {
	Identity downId = new Identity();
	Identity upId = new Identity();
	Identity stopId = new Identity();

	Logger expected = new Logger();
	expected.log( Event.makeVisitEvent(downId, n4) );
	expected.log( Event.makeVisitEvent(stopId, n4) );
	expected.log( Event.makeVisitEvent(upId, n4) );

	Visitor  visitor = new DownUp( 
	   logVisitor(downId), logVisitor(stopId), logVisitor(upId) );

	Visitable nodeReturned = visitor.visit(n4);
	assertEquals(expected, logger);
	assertEquals(n4, nodeReturned);
    }

    public void testDefUse() throws jjtraveler.VisitFailure {
	class Def extends Identity implements Collector {
	    public Collection getCollection() {
		HashSet result = new HashSet();
		result.add("aap");
		result.add("noot");
		return result;
	    }
	}
	class Use extends Identity implements Collector {
	    public Collection getCollection() {
		HashSet result = new HashSet();
		result.add("aap");
		result.add("mies");
		return result;
	    }
	}

	Def def = new Def();
	Use use = new Use();
	DefUse du = new DefUse(use, def);
	du.visit(n0);
	assertTrue( du.getUnused().contains("noot"));
	assertTrue( du.getUndefined().contains("mies"));
	assertEquals(1, du.getUnused().size());
	assertEquals(1, du.getUndefined().size());
    }


    public void testBacktrack() 
    throws jjtraveler.VisitFailure {
	class Increment implements StateVisitor {
	    Object localState = null;
	    public int state = 0;
	    public Object getState() {return new Integer(state);}
	    public void setState(Object o) {state = ((Integer) o).intValue();}
	    public Visitable visit(Visitable x) {
		state++; 
		localState = getState();
		return x;
	    }
	}

	Increment i = new Increment();
	Object initialState = i.getState();
	(new Backtrack(i)).visit(n0);
	assertNotNull(i.localState);
	assertTrue(! initialState.equals(i.localState));
	assertEquals(initialState,i.getState());
	assertEquals("",n0.getLogger().getTrace());
    }	

    public LogVisitor logVisitor(Visitor v) {
	return new LogVisitor(v, logger);
    }


    public void testBreadthFirst() 
      throws jjtraveler.VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, new Visitable[]{n4, n3, n2, n0, n1} );

	BreadthFirst bf = new BreadthFirst( logVisitor(id) );

	Visitable resultNode = bf.visit(n4);
	assertEquals(expected, logger);
	assertEquals(resultNode, n1);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.test.LibraryTest.class);
	return suite;
    }

}



