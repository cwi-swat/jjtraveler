package jjtraveler;

public class DoWhileSuccess extends DefinedCombinator {

    public DoWhileSuccess ( Visitor condition, Visitor action ) {
	setDefinition(
	      new IfThenElse( condition, 
			      new Sequence(action, new All(this))));
    }
}


					   
					 
