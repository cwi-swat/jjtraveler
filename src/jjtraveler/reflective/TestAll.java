package jjtraveler.reflective;

import junit.framework.*;

public class TestAll extends TestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new TestSuite(jjtraveler.reflective.WrapLogTest.class));
	return suite;
    }

}
