
javadir		= ${prefix}/classes/jjtraveler/reflective/test
JAVAROOT	= ${top_builddir}/src

#noinst_JAVA = @JAVA_JUNIT@

EXTRA_DIST  = ${java_JAVA}

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.reflective.test.TestAll" >> $@
	chmod +x $@

CLEANFILES = MainTest

java_JAVA = \
	TestAll.java\
	WrapLogTest.java

