package jjtraveler;
import junit.framework.*;
import jjtraveler.test.*;

public class NestingDepthTest extends VisitorTestCase {


    public NestingDepthTest(String test) {
        super(test);
    }

    public void testDepth2() throws VisitFailure {
	FailAtNodes recognize = new FailAtNodes(n1, n12);
	NestingDepth nd = new NestingDepth(recognize);
	nd.visit(n0);
	assertEquals(2,nd.getDepth());
    }
    public void notestDepth1() throws VisitFailure {
	FailAtNodes recognize = new FailAtNodes(n1, n1);
	NestingDepth nd = new NestingDepth(recognize);
	nd.visit(n0);
	assertEquals(1,nd.getDepth());
    }
    public void testDepth11() throws VisitFailure {
	FailAtNodes recognize = new FailAtNodes(n1, n2);
	NestingDepth nd = new NestingDepth(recognize);
	nd.visit(n0);
	assertEquals(1,nd.getDepth());
    }
}
