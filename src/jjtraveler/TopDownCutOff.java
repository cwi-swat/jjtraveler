package jjtraveler;

/** Search for particular nodes of which it is certain that they
 *  cannot be nested.
 *  In other words, it is safe to cut off the search as 
 *  soon as a node is found.
 */
public class TopDownCutOff implements Visitor {

    Visitor stopAt;
    Visitor performAction;

    Visitor tdco;

    public TopDownCutOff(Visitor stopAt, Visitor performAction) {
	this.stopAt = stopAt;
	this.performAction = performAction;
	tdco = new IfThenElse(stopAt, 
		       performAction, 
		       new All( this) );

    }

	
    public Visitable visitOld(Visitable x) throws VisitFailure {
	return (new IfThenElse(stopAt, 
	                       performAction, 
			       new All(this) ) ).visit(x);
    }

    public Visitable visit(Visitable x) throws VisitFailure {
	return tdco.visit(x);
    }

    public Visitable visitJoost(Visitable x) throws VisitFailure {
	return (new TopDownUntil(new Sequence(stopAt, performAction))).visit(x);
    }


}
