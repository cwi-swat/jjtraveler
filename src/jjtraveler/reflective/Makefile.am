DOCDIR		= ../doc
javapackage	= jjtraveler.reflective
packagedir	= jjtraveler/reflective
javadir		= $(prefix)/classes/$(packagedir)
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src
CLASSPATH_ENV = CLASSPATH=${JAVAROOT}:${JAVASRCROOT}:${top_srcdir}/jars/junit.jar

EXTRA_DIST = ${java_JAVA} ${EXTRA_JAVA} package.html

java_JAVA = \
	VisitableFail.java \
	VisitableIdentity.java \
	VisitableSequence.java \
	VisitableVisitor.java \
	VisitorFwd.java \
	VisitorVisitor.java \
	WrapLog.java \
	${EXTRA_JAVA}

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.reflective.TestAll" >> $@
	chmod +x $@

CLEANFILES = MainTest

EXTRA_JAVA = \
	TestAll.java\
	WrapLogTest.java

