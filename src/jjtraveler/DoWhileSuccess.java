package jjtraveler;

public class DoWhileSuccess extends TopDownWhile {
    
    public DoWhileSuccess ( Visitor condition, Visitor action ) {
	super(new IfThenElse(condition,
			     new Try(action),
			     new Fail() ) );
    }
}


					   
					 
