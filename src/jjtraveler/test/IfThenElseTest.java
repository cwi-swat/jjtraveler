package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;

public class IfThenElseTest extends VisitorTestCase {

    Identity idTrue = new Identity();
    Identity idFalse = new Identity();

    public IfThenElseTest(String test) {
        super(test);
    }

    public void testFalse() throws VisitFailure {
	Logger expected = new Logger();
	expected.log( new Event( idFalse, n0 ) );
	
	Visitable nodeReturned =
	    new IfThenElse( new Fail(),
			    logVisitor(idTrue),
			    logVisitor(idFalse) ) . visit(n0) ;

        assertEquals(expected, logger);
        assertEquals(n0, nodeReturned);
    }

    public void testTrue() throws VisitFailure {
	Logger expected = new Logger();
	expected.log( new Event( idTrue, n0 ) );
	
	Visitable nodeReturned =
	    new IfThenElse( new Identity(),
			    logVisitor(idTrue),
			    logVisitor(idFalse) ) . visit(n0) ;
	
        assertEquals(expected, logger);
        assertEquals(n0, nodeReturned);
    }


}
