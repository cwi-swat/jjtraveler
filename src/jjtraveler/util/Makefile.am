DIST_SUBDIRS = test

EXTRA_DIST = $(java_JAVA) $(EXTRA_JAVA)

java_JAVA = \
	ToStringVisitor.java \
	ToATermString.java \
	ToXMLString.java

javadir = ${prefix}/classes/jjtraveler/util
JAVAROOT = ${top_builddir}/src

EXTRA_JAVA = \
	TestAll.java \
	UtilTest.java

TESTS_JUNIT = MainTest 

TESTS = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.util.test.TestAll" >> $@
	chmod +x $@

CLEANFILES = MainTest
