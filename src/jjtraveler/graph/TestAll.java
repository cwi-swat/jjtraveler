package jjtraveler.graph;

import junit.framework.*;

public class TestAll extends TestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new TestSuite(jjtraveler.graph.VisitedTest.class));
	suite.addTest(new TestSuite(jjtraveler.graph.IsTreeTest.class));
	suite.addTest(new TestSuite(jjtraveler.graph.IsDagTest.class));
	return suite;
    }

}
