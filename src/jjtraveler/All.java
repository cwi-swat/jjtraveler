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

    public void visit(Visitable any) throws VisitFailure {
	int childCount = any.getChildCount();
	for (int i = 0; i < childCount; i++) {
	    v.visit(any.getChildAt(i));
	}
    }
    
}
