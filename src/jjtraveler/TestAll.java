package jjtraveler;

import junit.framework.*;
 
public class TestAll extends TestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new TestSuite(AllTest.class));
	suite.addTest(new TestSuite(FailTest.class));
	suite.addTest( new TestSuite(IdentityTest.class) );
	suite.addTest( new TestSuite(IfThenElseTest.class) );
	suite.addTest( new TestSuite(LibraryTest.class) );
	suite.addTest( new TestSuite(NestingDepthTest.class) );
	suite.addTest( new TestSuite(OnceTopDownTest.class) );
	suite.addTest( new TestSuite(SpineTopDownTest.class) );
	suite.addTest( new TestSuite(SpineBottomUpTest.class) );
	suite.addTest( new TestSuite(TopDownUntilTest.class) );
	suite.addTest( new TestSuite(DoWhileSuccessTest.class) );
	suite.addTest( new TestSuite(OneTest.class) );
	suite.addTest( new TestSuite(SomeTest.class) );
	suite.addTest( new TestSuite(CollectTest.class) );
	return suite;
    }
    
    public static void main(String argv[]) {
    	junit.textui.TestRunner.run(suite());
    }
}
