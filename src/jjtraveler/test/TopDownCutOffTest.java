package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;

public class TopDownCutOffTest extends VisitorTestCase {

    public TopDownCutOffTest(String test) {
        super(test);
    }

    public void testTopDownCutOff() throws VisitFailure {
	CutOffExample stopAt = new CutOffExample(n1, n2);

        Identity id = new Identity();
        Logger expected = new Logger();
	expected.log( new Event( stopAt, n0 ));
	expected.log( new Event( stopAt, n1 ));
	expected.log( new Event( id, n1 ));
	expected.log( new Event( stopAt, n2) );
	expected.log( new Event( id, n2));

        Visitable nodeReturned = 
	    new TopDownCutOff( logVisitor(stopAt), logVisitor(id) ). visit(n0);

        assertEquals(expected, logger);
        assertEquals(n0, nodeReturned);
    }

    public class CutOffExample implements jjtraveler.Visitor {
	Visitable stopNode1;
	Visitable stopNode2;
	public CutOffExample(Visitable n1, Visitable n2) {
	    stopNode1 = n1;
	    stopNode2 = n2;
	}
	public Visitable visit(Visitable x) throws VisitFailure {
	    if (! (x == stopNode1 || x == stopNode2) ){
		throw (new VisitFailure());
	    }
	    return x;
	}
    }

}
