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
	$(JAVA_JUNIT)

javapackage	= jjtraveler.graph
javadir		= ${prefix}/classes/jjtraveler/graph
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src

EXTRA_DIST	= package.html

JAVA_JUNIT = \
	TestAll.java\
	VisitedTest.java\
	IsTreeTest.java\
	IsDagTest.java\
	ToGraphTest.java\
	EdgesGraphTest.java \
	WhileNotVisitedTest.java 

noinst_JAVA = $(JAVA_JUNIT)

EXTRA_JAVA  = $(JAVA_JUNIT)

TESTS_JUNIT = MainTest 

TESTS       = $(TESTS_JUNIT)

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ $(javapackage).TestAll" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES += MainTest
