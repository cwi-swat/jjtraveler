package jjtraveler;

public class DoWhileSuccess implements Visitor {

    Visitor dws;
    
    public DoWhileSuccess ( Visitor condition, Visitor action ) {
	dws = new IfThenElse( condition, 
			      new Sequence(action, new All(this)));
    }

    public Visitable visit(Visitable x) throws VisitFailure {
	return dws.visit(x);
    }
}


					   
					 
