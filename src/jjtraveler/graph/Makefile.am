javapackage	= jjtraveler.graph
javadir		= ${prefix}/classes/jjtraveler/graph
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src
CLASSPATH_ENV = CLASSPATH=${JAVAROOT}:${JAVASRCROOT}:${top_srcdir}/jars/junit.jar

EXTRA_DIST	= ${java_JAVA} ${EXTRA_JAVA} package.html

java_JAVA =\
	Visited.java\
	NotVisited.java\
	IsTree.java\
	IsDag.java\
	ASTToGraph.java\
	Graph.java\
	MkEdgesToKids.java\
	EdgesGraph.java\
	MkEdgeFromParent.java\
	ToGraph.java\
	WhileNotVisited.java \
	${EXTRA_JAVA}

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.graph.TestAll" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES = MainTest

EXTRA_JAVA = \
	TestAll.java\
	VisitedTest.java\
	IsTreeTest.java\
	IsDagTest.java\
	ToGraphTest.java\
	EdgesGraphTest.java \
	WhileNotVisitedTest.java 
