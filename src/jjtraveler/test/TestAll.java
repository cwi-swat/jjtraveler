package jjtraveler.test;
import junit.framework.*;

public class TestAll extends VisitorTestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest( new TestSuite( jjtraveler.test.IdentityTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.OneTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.AllTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.OnceTopDownTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.IfThenElseTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.TopDownCutOffTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.NestingDepthTest.class) );
	suite.addTest( new TestSuite( jjtraveler.test.LibraryTest.class) );
	return suite;
    }

}
