package jjtraveler;


public class SuccessCounter implements Visitor {

    int success = 0;
    int failure = 0;
    Visitor action;

    public SuccessCounter(Visitor v) {
	action = v;
    }

    public int getSuccesses() {
	return success;
    }

    public int getFailures() {
	return failure;
    }

    public Visitable visit(Visitable x) {
	try {
	    action.visit(x);
	    success++;
	} catch (VisitFailure vf) {
	    failure++;
	}
	return x;
    }
}
