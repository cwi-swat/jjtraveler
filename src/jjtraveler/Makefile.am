java_JAVA = \
VisitFailure.java \
Visitor.java \
Visitable.java \
Identity.java \
Sequence.java \
Fail.java \
Choice.java \
All.java \
One.java \
Try.java \
TopDown.java \
BottomUp.java \
OnceTopDown.java \
OnceBottomUp.java \
DownUp.java \
SpineTopDown.java \
SpineBottomUp.java \
Collector.java \
DefUse.java \
VoidVisitor.java \
Not.java \
StateVisitor.java \
Backtrack.java \
BreadthFirst.java \
TopDownUntil.java \
TopDownWhile.java \
GuaranteeSuccess.java \
IfThenElse.java \
TopDownCutOff.java \
NestingDepth.java \
@JAVA_JUNIT@

javapackage	= jjtraveler
javadir		= ${prefix}/classes/jjtraveler
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src

SUBDIRS		= util test reflective graph

JAVA_JUNIT = \
	TestAll.java \
	FailTest.java

EXTRA_DIST	= package.html overview.html.src

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


#
# Creating the javadocs
#

all-local: htmljava.stamp

install-data-local: html-install

clean-local: html-clean

htmljava.stamp: $(java_JAVA) overview.html
	mkdir -p ./doc
	@JAVADOC@ -windowtitle "JJTraveler Documentation" \
	  -sourcepath ${JAVASRCROOT} -classpath ${CLASSPATH} \
	  -overview overview.html \
	  -use -private -d ./doc \
	  jjtraveler jjtraveler.util jjtraveler.test jjtraveler.reflective
	echo timestamp > htmljava.stamp

html-install: htmljava.stamp
	$(mkinstalldirs) $(datadir)/doc/jjtraveler
	cp -r ./doc/* $(datadir)/doc/jjtraveler

html-clean:
	rm -fr ./doc htmljava.stamp overview.html

echo-classpath:
	@echo ${CLASSPATH}

%: %.src
	sed s/__VERSION__/${VERSION}/g $< > $@
