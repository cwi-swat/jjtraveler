package jjtraveler.test;

import jjtraveler.*;

public class LogVisitor implements Visitor {
    Visitor visitor;
    Logger logger;
    String visitorName;
    
    public LogVisitor(Visitor v, Logger l, String n) {
	visitor = v;
	logger = l;
	visitorName = n;
    }

    public LogVisitor(Visitor v, Logger l) {
	visitor = v;
	logger = l;
	visitorName = v.getClass().getName();
    }


    public Visitable visit(Visitable visitable) throws VisitFailure {
	Event e = Event.makeVisitEvent( visitor, visitable );
	logger.log(e);
	return visitor.visit( visitable );
    }

}
