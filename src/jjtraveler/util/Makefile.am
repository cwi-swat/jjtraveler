EXTRA_DIST = $(java_JAVA) $(EXTRA_JAVA)

java_JAVA = \
	ToStringVisitor.java \
	ToATermString.java \
	ToXMLString.java \
	${EXTRA_JAVA}

javadir = ${prefix}/classes/jjtraveler/util
JAVAROOT = ${top_builddir}/src
JAVASRCROOT = ${top_srcdir}/src
CLASSPATH_ENV = CLASSPATH=${JAVAROOT}:${JAVASRCROOT}:${top_srcdir}/jars/junit.jar

EXTRA_JAVA = \
	TestAll.java \
	UtilTest.java 

TESTS_JUNIT = MainTest 

TESTS = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.util.TestAll" >> $@
	chmod +x $@

CLEANFILES = MainTest
