package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;


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
	Logger expected = new Logger();
	expected.log( Event.makeVisitEvent(id, n0) );
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

	Logger expected = new Logger();
	expected.log( Event.makeVisitEvent(id, n0) );

	Choice  ch = new Choice( logVisitor(id), new Identity() );

	Visitable nodeReturned = ch.visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
    }


    public void testRightChoice() throws VisitFailure {
	Identity id = new Identity();

	Logger expected = new Logger();
	expected.log( Event.makeVisitEvent(id, n0) );

	Choice  ch = new Choice( new Fail(), logVisitor(id) );

	Visitable nodeReturned = ch.visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
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
	BreadthFirst bf = new BreadthFirst( logVisitor(id) );

        Logger expected = new Logger();
	expected.log( Event.makeVisitEvent(id, n4) );
	expected.log( Event.makeVisitEvent(id, n3) );
	expected.log( Event.makeVisitEvent(id, n2) );
	expected.log( Event.makeVisitEvent(id, n0) );
	expected.log( Event.makeVisitEvent(id, n1) );

	Visitable resultNode = bf.visit(n4);
	assertEquals(expected, logger);
	assertEquals(resultNode, n1);
    }

    /*
    public void testBreadthFirst()
      throws jjtraveler.VisitFailure {
	BreadthFirst v = new BreadthFirst(new Identity());
	v.visit(n0);
	assertEquals("Node.getChildCount",n0.getLogger().getTrace());

	n0.getLogger().reset();
	v = new BreadthFirst(new LogVisitor(new Identity(), n0.getLogger()));
	v.visit(n4);

	assertEquals("jjtraveler.Identity.visit(Node-4)"+
		     "Node.getChildCount"+"Node.getChildAt"+"Node.getChildAt"+
		     "jjtraveler.Identity.visit(Node-3)"+
		     "Node.getChildCount"+"Node.getChildAt"+"Node.getChildAt"+
		     "jjtraveler.Identity.visit(Node-2)"+
		     "Node.getChildCount"+
		     "jjtraveler.Identity.visit(Node-0)"+
		     "Node.getChildCount"+
		     "jjtraveler.Identity.visit(Node-1)"+
		     "Node.getChildCount",
		     n0.getLogger().getTrace());
    }
    */
    /*
    Trace expected = 
	new Trace( 
		  new Event[] {
	    new VisitEvent(id, n4)
	    }
	    )
    */
	
    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.test.LibraryTest.class);
	return suite;
    }

}



