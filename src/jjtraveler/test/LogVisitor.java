package jjtraveler.test;

import jjtraveler.*;

public class LogVisitor implements Visitor {
    Visitor visitor;
    Logger logger;
    
    public LogVisitor(Visitor v, Logger l) {
	visitor = v;
	logger = l;
    }

    public Visitable visit(Visitable visitable) throws VisitFailure {
	logger.log( new Event(visitor, visitable) );
	return visitor.visit( visitable );
    }

}
