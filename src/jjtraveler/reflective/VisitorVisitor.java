package jjtraveler.reflective;

import jjtraveler.*;

/**
 * A visitor for visiting VisitableVisitors
 */

public abstract class VisitorVisitor implements Visitor {

    public Visitable visit(Visitable any) throws VisitFailure {
	if (any instanceof VisitableVisitor) {
	    return visitVisitor((VisitableVisitor) any);
	} else {
	    throw new VisitFailure();
	}
    }

    public abstract VisitableVisitor visitVisitor(VisitableVisitor any)
	throws VisitFailure;

}
