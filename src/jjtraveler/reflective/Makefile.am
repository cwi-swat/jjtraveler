java_JAVA =\
	VisitorVisitor.java\
	VisitableVisitor.java\
	VisitorFwd.java\
	VisitableIdentity.java\
	VisitableFail.java\
	VisitableSequence.java\
	WrapLog.java\
	@JAVA_JUNIT@

javapackage	= jjtraveler.reflective
javadir		= ${prefix}/classes/jjtraveler/reflective
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src

JAVA_JUNIT = \
	TestAll.java \
	WrapLogTest.java

EXTRA_DIST	= package.html

noinst_JAVA = @JAVA_JUNIT@

EXTRA_JAVA  = $(JAVA_JUNIT)

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ $(javapackage).TestAll" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES += MainTest