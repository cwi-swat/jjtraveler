package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;


public class LibraryTest extends TestCase 
{

    Node n1;

    public LibraryTest(String test) {
	super(test);
    }

    protected void setUp() {
	Node.reset();
	Node[] empty = {};
	n1 = Node.factory(empty);
    }

    public void testIdentity() throws VisitFailure {
	(new Identity()).visit(n1);
	assertEquals("", n1.getLogger().getTrace());

	(new LogVisitor(new Identity(), n1.getLogger())).visit(n1);
	assertEquals("jjtraveler.Identity.visit(Node-0)", n1.getLogger().getTrace());
    }

    public void testFail() {
	try {
	    (new Fail()).visit(n1);
	    fail();
	}
	catch(VisitFailure vf) {
	    assertEquals("", n1.getLogger().getTrace());
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
	(new Backtrack(i)).visit(n1);
	assertEquals(initialState,i.getState());
	assertEquals("",n1.getLogger().getTrace());
    }	
	
    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.test.LibraryTest.class);
	return suite;
    }

}



