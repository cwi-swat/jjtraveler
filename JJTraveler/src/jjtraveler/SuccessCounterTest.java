package jjtraveler;

import jjtraveler.SuccessCounter;
import jjtraveler.TopDown;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;

/** Test cases for the SuccessCounter
 * combinator.
 * 
 * @author Arie van Deursen; Jun 30, 2003 
 * @version $Id$
 */

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
