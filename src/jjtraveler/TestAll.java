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
	suite.addTest( new TestSuite(jjtraveler.IfThenElseTest.class) );
	suite.addTest( new TestSuite(jjtraveler.LibraryTest.class) );
	suite.addTest( new TestSuite(jjtraveler.NestingDepthTest.class) );
	suite.addTest( new TestSuite(jjtraveler.OnceTopDownTest.class) );
	suite.addTest( new TestSuite(jjtraveler.OneTest.class) );
	suite.addTest( new TestSuite(jjtraveler.TopDownCutOffTest.class) );
	return suite;
    }

}
