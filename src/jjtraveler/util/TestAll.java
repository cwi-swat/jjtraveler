package jjtraveler.util;

import junit.framework.*;
import jjtraveler.test.VisitorTestCase;

public class TestAll extends VisitorTestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest( new TestSuite(jjtraveler.util.UtilTest.class) );
	suite.addTest( new TestSuite(jjtraveler.util.ToGraphTest.class) );
	return suite;
    }

}
