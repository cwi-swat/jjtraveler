package jjtraveler;

/**
 * <code>T(t1,..,tN).accept(All(v)) = T(t1.accept(v),..,tN.accept(v))</code>
 * <p>
 * Basic visitor combinator with one visitor argument, that applies
 * this visitor to all children.
 */

public class All implements Visitor {

    public Visitor v;

    public All(Visitor v) {
	this.v = v;
    }

    public Visitable visit(Visitable any) throws VisitFailure {
	int childCount = any.getChildCount();
	Visitable result = any;
	for (int i = 0; i < childCount; i++) {
	    result = result.setChildAt(i,v.visit(result.getChildAt(i)));
	}
	return result;
    }
    
}
