java_JAVA = \
	Node.java NodeVisitor.java\
	Logger.java LogVisitor.java Event.java \
	VisitorTestCase.java FailAtNodes.java \
	SucceedAtNodes.java \
	TimeLogVisitor.java \
	@JAVA_JUNIT@

javadir		= ${prefix}/classes/jjtraveler/test
JAVAROOT        = ${top_builddir}/src

JAVA_JUNIT = \
	FailAtNodesTest.java\
	TestAll.java\
	LoggerTest.java\
	TimeLogVisitorTest.java \
	AllSpinesBottomUpTest.java \
	AllTest.java \
	FailTest.java \
	IdentityTest.java \
	IfThenElseTest.java \
	LibraryTest.java \
	NestingDepthTest.java \
	OnceTopDownTest.java \
	SpineTopDownTest.java \
	SomeTest.java \
	SpineBottomUpTest.java \
	TopDownUntilTest.java \
	DoWhileSuccessTest.java \
	OneTest.java \
	SuccessCounterTest.java \
	CollectTest.java

EXTRA_DIST = package.html

#noinst_JAVA = @JAVA_JUNIT@

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
