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
	Node[] empty = {};
	n1 = Node.factory(empty);
    }

    public void testIdentity() {
	(new Identity()).visit(n1);
	assertEquals("", n1.getLogger().getTrace());
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
	
    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.test.LibraryTest.class);
	return suite;
    }

}



