package jjtraveler;

/* The visitor combinator GuaranteeSuccess can be used to indicate
 * that its argument visitor v is guaranteed to succeed. Note that
 * the visit method of GuaranteeSuccess does not throw VisitFailures,
 * while the visit method of its argument visitor v might.
 */

public class GuaranteeSuccess implements Visitor {
    Visitor v;

    public GuaranteeSuccess(Visitor v) {
	this.v = v;
    }
    
    /* Visit the current visitable with the argument visitor v,
     * and turn any VisitFailure that might occur into a 
     * RuntimeException.
     */
    public Visitable visit(Visitable visitable) {
	Visitable result;
	try { return v.visit(visitable); }
	catch (VisitFailure f) {
	    throw new RuntimeException();
	}
    }
}
