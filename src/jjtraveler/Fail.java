package jjtraveler;

/**
 * <code>x.accept(Fail)</code> always raises a VisitFailure exception. 
 * <p>
 * Basic visitor combinator without arguments, that always fails.
 */

public class Fail implements Visitor {

    public void visit(Visitable any) throws VisitFailure {
	throw new VisitFailure();
    }

}
