package jjtraveler.reflective;

import junit.framework.*;
import jjtraveler.*;
import jjtraveler.test.*;

public class WrapLogTest extends VisitorTestCase {

    public void testWrapIdentity() throws VisitFailure {
	VisitableVisitor i = new VisitableIdentity();
	WrapLog w = new WrapLog(logger);
	Visitor v = w.visitVisitor(i);
	Visitable result = v.visit(n0);
	Logger expectedLogger = new Logger(i,new Visitable[]{n0});
	assertEquals(expectedLogger,logger);
	assertEquals(n0,result);
    }

    public void testWeaveSequence() throws VisitFailure {
	VisitableVisitor i = new VisitableIdentity();
	VisitableVisitor s = new VisitableSequence(i,i);
	WrapLog w = new WrapLog(logger);
	Visitor v = (VisitableVisitor) (new BottomUp(w)).visit(s);
	Visitable result = v.visit(n0);
	Logger expectedLogger = new Logger();
	expectedLogger.log(new Event(s,n0));
	expectedLogger.log(new Event(i,n0));
	expectedLogger.log(new Event(i,n0));
	assertEquals(expectedLogger,logger);
	assertEquals(n0,result);
    }

    public WrapLogTest(String test) {
        super(test);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(jjtraveler.util.UtilTest.class);
        return suite;
    }

}
