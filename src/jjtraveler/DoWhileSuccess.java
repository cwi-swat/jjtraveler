package jjtraveler;

public class DoWhileSuccess extends GuaranteeSuccess {
    
    public DoWhileSuccess ( Visitor condition, Visitor action ) {
	super(new TopDownWhile(
			       new IfThenElse(condition,
					      new Try(action),
					      new Fail() ) ) );
    }
}


					   
					 
