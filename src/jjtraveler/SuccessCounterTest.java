package jjtraveler;

import jjtraveler.test.FailAtNodes;
import jjtraveler.test.VisitorTestCase;

public class SuccessCounterTest extends VisitorTestCase {

    public SuccessCounterTest(String test) {
        super(test);
    }

    public void testSuccessCounter() throws VisitFailure {
	Visitor action = new FailAtNodes(n1, n2);
	SuccessCounter sc = new SuccessCounter(action);

	Visitable nodeReturned = 
	    ( new TopDown(sc) ). visit(n0);

        assertEquals(n0, nodeReturned);
	assertEquals(3, sc.getSuccesses());
	assertEquals(2, sc.getFailures());
    }
}
