package jjtraveler.reflective;

import jjtraveler.*;

public class VisitorFwd extends VisitorVisitor {
    
    Visitor visitor;

    public VisitorFwd(Visitor visitor) {
	this.visitor = visitor;
    }

    public VisitableVisitor visitVisitor(VisitableVisitor x)
      throws VisitFailure {
	return (VisitableVisitor) visitor.visit(x);
    }
}
