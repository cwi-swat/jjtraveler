package jjtraveler;

import junit.framework.*;

public class TestAll extends TestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new TestSuite(jjtraveler.FailTest.class));
	suite.addTest( new TestSuite(jjtraveler.IdentityTest.class) );
	return suite;
    }

}
