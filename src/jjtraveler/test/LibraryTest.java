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

    public LibraryTest(String test) {
	super(test);
    }

    protected void setUp() {
	Node.reset();
	Node[] empty = {};
	n0 = Node.factory(empty);
	n1 = Node.factory(empty);
	n2 = Node.factory(empty);
	n3 = Node.factory(new Node[]{n0,n1});
	n4 = Node.factory(new Node[]{n3,n2});
    }

    public void testIdentity() throws VisitFailure {
	(new Identity()).visit(n0);
	assertEquals("", n0.getLogger().getTrace());

	(new LogVisitor(new Identity(), n0.getLogger())).visit(n0);
	assertEquals("jjtraveler.Identity.visit(Node-0)", n0.getLogger().getTrace());
    }

    public void testFail() {
	try {
	    (new Fail()).visit(n0);
	    fail();
	}
	catch(VisitFailure vf) {
	    assertEquals("", n0.getLogger().getTrace());
	}
    }

    public void testBacktrack() 
    throws jjtraveler.VisitFailure {
	class Increment implements StateVisitor {
	    public int state = 0;
	    public Object getState() {return new Integer(state);}
	    public void setState(Object o) {state = ((Integer) o).intValue();}
	    public Visitable visit(Visitable x) {
		state++; 
		return x;
	    }
	}

	Increment i = new Increment();
	Object initialState = i.getState();
	(new Backtrack(i)).visit(n0);
	assertEquals(initialState,i.getState());
	assertEquals("",n0.getLogger().getTrace());
    }	

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
	
    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.test.LibraryTest.class);
	return suite;
    }

}



