java_JAVA = \
	Node.java NodeVisitor.java\
	Logger.java LogVisitor.java Event.java \
	VisitorTestCase.java \
	@JAVA_JUNIT@

javadir		= ${prefix}/classes/jjtraveler/test
JAVAROOT        = ${top_builddir}/src

JAVA_JUNIT = \
	TestAll.java \
	LibraryTest.java\
	IdentityTest.java\
	FailTest.java\
	UtilTest.java \
	IfThenElseTest.java \
	TopDownCutOffTest.java 

noinst_JAVA = @JAVA_JUNIT@

EXTRA_JAVA  = $(JAVA_JUNIT)

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.test.TestAll" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES=MainTest
