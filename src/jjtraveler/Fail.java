package jjtraveler;

/**
 * <code>x.accept(Fail)</code> always raises a VisitFailure exception. 
 * <p>
 * Basic visitor combinator without arguments, that always fails.
 * <p>
 * Test case documentation:
 * <a href="FailTest.java">FailTest</a>
 */

public class Fail implements Visitor {

    public Visitable visit(Visitable any) throws VisitFailure {
	throw new VisitFailure();
    }

}
