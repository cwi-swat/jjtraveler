package jjtraveler.test;

import jjtraveler.*;

/*
 * Simple visitor recognizing two nodes given at creation time.
 * Can be used to test generic visitors requiring a recognizing
 * argument.
 */

public class FailAtNodes implements jjtraveler.Visitor {
    Visitable failNode1;
    Visitable failNode2;
    public FailAtNodes(Visitable n1, Visitable n2) {
	failNode1 = n1;
	failNode2 = n2;
    }
    public Visitable visit(Visitable x) throws VisitFailure {
	if (x.equals(failNode1) || x.equals(failNode2) ){
	    throw (new VisitFailure());
	} else {
	    //
	}
	return x;
    }
}
