
javadir = ${prefix}/classes/jjtraveler/graph/test
JAVAROOT = ${top_builddir}/src

EXTRA_DIST = ${java_JAVA}

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.graph.test.TestAll" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES = MainTest

java_JAVA = \
	TestAll.java\
	VisitedTest.java\
	IsTreeTest.java\
	IsDagTest.java\
	ToGraphTest.java\
	EdgesGraphTest.java \
	WhileNotVisitedTest.java 
