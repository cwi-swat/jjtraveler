package jjtraveler;

/**
 * <code>x.accept(Sequence(v1,v2)) = x.accept(v1) ; x.accept(v2)</code>
 * <p>
 * Basic visitor combinator with two visitor arguments, that applies
 * these visitors one after the other (sequential composition).
 */

public class Sequence implements Visitor {
    
    Visitor first;
    Visitor then;
    
    public Sequence(Visitor first, Visitor then) {
	this.first = first;
	this.then  = then;
    }

    public void visit(Visitable any) throws VisitFailure {
	first.visit(any);
	then.visit(any);
    }

}
