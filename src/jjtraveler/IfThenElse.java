package jjtraveler;

public class IfThenElse implements Visitor {

    Visitor condition;
    Visitor trueCase;
    Visitor falseCase;

    public IfThenElse(Visitor c, Visitor t, Visitor f) {
	condition = c;
	trueCase = t;
	falseCase = f;
    }

    public Visitable visit(Visitable x) throws VisitFailure {
	return (new Choice( new Sequence( condition, trueCase ), 
			    falseCase ) ) . visit(x) ;
    }
}
