package jjtraveler.util.test;

import jjtraveler.test.VisitorTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll extends VisitorTestCase {

    public TestAll(String test) {
	super(test);
    }

    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest( new TestSuite(jjtraveler.util.test.UtilTest.class) );
	return suite;
    }

}
