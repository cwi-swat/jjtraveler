package jjtraveler;

public abstract class VoidVisitor implements Visitor{

    public final Visitable visit(Visitable any)
    throws VisitFailure {
	voidVisit(any);
	return any;
    }

    public abstract void voidVisit(Visitable any) throws VisitFailure;

}
