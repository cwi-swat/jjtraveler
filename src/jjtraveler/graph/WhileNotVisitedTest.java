package jjtraveler.graph;

import junit.framework.*;
import jjtraveler.*;
import jjtraveler.test.*;

public class WhileNotVisitedTest extends VisitorTestCase {

    public WhileNotVisitedTest(String test) {
        super(test);
    }

    public void testCircle()  throws VisitFailure {
	Visitor id = new Identity();

	Visitable returned = 
	    new WhileNotVisited( logVisitor(id) ) . visit( rootOfCircle );

	Visitable bottomOfCircle = rootOfCircle.getChildAt(0);

	Logger expected = 
	    new Logger( id, new Visitable[]{ rootOfCircle,
					     bottomOfCircle } );

	assertEquals(expected, logger);
    }

}
