package jjtraveler.test;
import junit.framework.*;

public class TestAll extends VisitorTestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new TestSuite(jjtraveler.test.FailAtNodesTest.class));
	suite.addTest(new TestSuite(jjtraveler.test.LoggerTest.class));
	suite.addTest(new TestSuite(jjtraveler.test.TimeLogVisitorTest.class));
	return suite;
    }

}
