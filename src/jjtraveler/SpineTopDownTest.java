package jjtraveler;

import jjtraveler.test.*;

public class SpineTopDownTest extends VisitorTestCase {

    public SpineTopDownTest(String test) {
	super(test);
    }

    public void testSpineTopDownAtLeaves() {
	Visitor failAtTwoLeaves = new FailAtNodes(n11, n12);
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(failAtTwoLeaves));
	Logger expected = new Logger(failAtTwoLeaves, new Visitable[]{n0,n1,n11,n12,n2});
	try {
	    Visitable nodeReturned = spineTopDown.visit(n0);
	    assertEquals("visit trace",expected, logger);
	    assertEquals("return value",n0, nodeReturned);
	} catch (VisitFailure vf) {
	    fail("VisitFailure should not occur!");
	}
    }

    public void testSpineTopDownAtInnerNodes() {
	Visitor failAtInners = new FailAtNodes(n1);
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(failAtInners));
	Logger expected = new Logger(failAtInners, new Visitable[]{n0,n1,n2});
	try {
	    Visitable nodeReturned = spineTopDown.visit(n0);
	    assertEquals("visit trace",expected, logger);
	    assertEquals("return value",n0, nodeReturned);
	} catch (VisitFailure vf) {
	    fail("VisitFailure should not occur!");
	}
    }

    public void testSpineTopDownAtFailure() {
	Visitor isLeaf = new All(new Fail());
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(isLeaf));
	Logger expected = new Logger(isLeaf, new Visitable[]{n0});
	Visitable nodeReturned = null;
	try {
	    nodeReturned = spineTopDown.visit(n0);
	    fail("VisitFailure should have occured!");
	} catch (VisitFailure vf) {
	    assertEquals("visit trace",expected, logger);
	    assertNull("return value",nodeReturned);
	}
    }
}
