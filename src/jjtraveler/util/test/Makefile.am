
javadir = ${prefix}/classes/jjtraveler/util/test

JAVAROOT = ${top_builddir}/src

java_JAVA = \
	TestAll.java \
	UtilTest.java


EXTRA_DIST = $(java_JAVA)

TESTS_JUNIT = MainTest 

TESTS = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.util.test.TestAll" >> $@
	chmod +x $@

CLEANFILES = MainTest
