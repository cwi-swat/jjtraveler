package jjtraveler.test;
import junit.framework.*;

public class TestAll extends VisitorTestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite(jjtraveler.test.UtilTest.class);
	suite.addTest( new TestSuite( jjtraveler.test.IdentityTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.LibraryTest.class) );
	return suite;
    }

}
