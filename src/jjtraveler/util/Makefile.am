java_JAVA = \
	ASTToGraph.java\
	Graph.java\
	MkEdgesToKids.java\
	EdgesGraph.java\
	MkEdgeFromParent.java\
	ToStringVisitor.java\
	ToGraph.java\
	@JAVA_JUNIT@

javadir		= ${prefix}/classes/jjtraveler/util
JAVAROOT        = ${top_builddir}/src

JAVA_JUNIT = \
	TestAll.java \
	UtilTest.java\
	ToGraphTest.java\
	EdgesGraphTest.java

noinst_JAVA = @JAVA_JUNIT@

EXTRA_JAVA  = $(JAVA_JUNIT)

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.util.TestAll" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES=MainTest
