package jjtraveler.graph;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAll extends TestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new TestSuite(jjtraveler.graph.test.VisitedTest.class));
	suite.addTest(new TestSuite(jjtraveler.graph.test.WhileNotVisitedTest.class));
	suite.addTest(new TestSuite(jjtraveler.graph.test.IsTreeTest.class));
	suite.addTest(new TestSuite(jjtraveler.graph.test.IsDagTest.class));
	suite.addTest( new TestSuite(jjtraveler.graph.test.ToGraphTest.class) );
	suite.addTest( new TestSuite(jjtraveler.graph.test.EdgesGraphTest.class) );
	return suite;
    }

}
