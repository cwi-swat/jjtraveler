package jjtraveler.test;

import jjtraveler.*;
import java.util.*;

/*
 * Simple visitor recognizing two nodes given at creation time.
 * Can be used to test generic visitors requiring a recognizing
 * argument.
 */

public class FailAtNodes implements jjtraveler.Visitor {
    Set visitables = new HashSet();

    public FailAtNodes(Collection visitables) {
	this.visitables.addAll(visitables);
    }

    public FailAtNodes(Visitable n1, Visitable n2) {
	visitables.add(n1);
	visitables.add(n2);
    }

    public Visitable visit(Visitable x) throws VisitFailure {
	if (visitables.contains(x)) {
	    throw (new VisitFailure());
	} 
	return x;
    }
}
