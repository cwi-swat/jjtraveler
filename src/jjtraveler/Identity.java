package jjtraveler;

/**
 * <code>x.accept(Identity) = x</code>
 * <p>
 * Basic visitor combinator without arguments that does nothing.
 */

public class Identity implements Visitor {

    public void visit(Visitable x) { }

}
