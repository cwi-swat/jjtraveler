package jjtraveler;

public class DoWhileSuccess extends DefinedCombinator {

    private Visitor action = new Identity();
    private Visitor condition = new Identity();
    private Visitor atBorder = new Identity();

    public DoWhileSuccess ( Visitor condition, Visitor action ) {
	this.condition = condition;
	this.action = action;
    }

    /** Same as TopDownWhile(v)
     */
    public DoWhileSuccess(Visitor condition) {
	this.condition = condition;
    }

    /** Most generic form, having different behavior in
     *  conditions, at success, and at the failing border.
     */
    public DoWhileSuccess ( Visitor condition, Visitor action, Visitor atBorder ) {
	this.condition = condition;
	this.action = action;
	this.atBorder = atBorder;
    }

    /** Reuse DoWhileSuccess(v) as a TopDownWhile(v).
     */
    public static DoWhileSuccess TopDownWhile(Visitor v1) {
	return new DoWhileSuccess(v1);
    }

    /** Reuse DoWhileSuccess(v1,id,v2) as a TopDownWhile(v1,v2)
     */
    public static DoWhileSuccess TopDownWhile(Visitor v1, Visitor v2) {
	return new DoWhileSuccess(v1, new Identity(), v2);
    }

    /** Reuse DoWhileSuccess(id,v,id) as a TopDown(v);
     */
    public static DoWhileSuccess TopDown(Visitor v) {
	return new DoWhileSuccess(new Identity(), v, new Identity());
    }

    /** Reuse DoWhileSuccess(not(v)) as a TopDownUntil(v);
     */
    static DoWhileSuccess TopDownUntil(Visitor v1) {
	return new DoWhileSuccess(new Not(v1));
    }
	
    
    Visitor getDefinition() {
	return 
	    new IfThenElse( condition, 
			    new Sequence(action, new All(this)),
			    atBorder
			    );
    }
}


					   
					 
