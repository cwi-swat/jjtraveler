package jjtraveler.test;

import jjtraveler.*;

/** 
 * A combinator that generates a loggable event before and after 
 * each time that its argument visitor is invoked.
 */

public class TimeLogVisitor extends LogVisitor {

    long firstInvocationTimeStamp = 0;
    long lastReturnTimeStamp;
    long consumedTime = 0;

    public TimeLogVisitor(Visitor v, Logger l) {
	super(v,l);
    }

    public Visitable visit(Visitable visitable) throws VisitFailure {
	long startTime = System.currentTimeMillis();
	if (firstInvocationTimeStamp == 0) {
	    firstInvocationTimeStamp = startTime;
	}

	logger.log( new Event(visitor,visitable) );
	Visitable result = visitor.visit( visitable );

	long endTime = System.currentTimeMillis();
	lastReturnTimeStamp = endTime;
	consumedTime = consumedTime + (endTime - startTime);

	return result;
    }

    public long getElapsedTime() {
	return lastReturnTimeStamp - firstInvocationTimeStamp;
    }
    public long getConsumedTime() {
	return consumedTime;
    }

}
