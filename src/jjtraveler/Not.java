package jjtraveler;

/**
 * Basic visitor combinator with a single argument. Not(v) succeeds
 * if and only if v fails.
 */

public class Not implements Visitor {

    Visitor v;

    public Not(Visitor v) {
	this.v = v;
    }

    public Visitable visit(Visitable x) throws VisitFailure {
	try {
	    v.visit(x);
	}
	catch (VisitFailure f) {
	    return x;
	}
	throw new VisitFailure();
    }

}
