java_JAVA = \
Node.java NodeVisitor.java Logger.java LogVisitor.java Event.java \
@JAVA_JUNIT@

javadir		= ${prefix}/classes/jjtraveler/test
JAVAROOT        = ${top_builddir}/src

JAVA_JUNIT = \
LibraryTest.java

noinst_JAVA = @JAVA_JUNIT@

EXTRA_JAVA  = $(JAVA_JUNIT)

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.test.LibraryTest" >> $@
	chmod +x $@

JAVACC      = @JAVACC@

CLEANFILES=MainTest
