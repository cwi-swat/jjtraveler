package jjtraveler.test;

import jjtraveler.*;

public class LogVisitor implements Visitor {
    Visitor visitor;
    NodeLogger logger;
    String visitorName;
    
    public LogVisitor(Visitor v, NodeLogger l, String n) {
	visitor = v;
	logger = l;
	visitorName = n;
    }

    public LogVisitor(Visitor v, NodeLogger l) {
	visitor = v;
	logger = l;
	visitorName = v.getClass().getName();
    }


    public Visitable visit(Visitable x) throws VisitFailure {
	logger.log(visitorName+".visit("+x+")");
	return visitor.visit(x);
    }

}
