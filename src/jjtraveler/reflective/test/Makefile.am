java_JAVA = \
        @JAVA_JUNIT@

javadir		= ${prefix}/classes/jjtraveler/reflective/test
JAVAROOT	= ${top_builddir}/src

JAVA_JUNIT=\
	TestAll.java\
	WrapLogTest.java

noinst_JAVA = @JAVA_JUNIT@

EXTRA_JAVA  = $(JAVA_JUNIT)

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.reflective.test.TestAll" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES += MainTest
