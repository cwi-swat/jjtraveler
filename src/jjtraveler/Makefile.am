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
NestingDepth.java \
DoWhileSuccess.java \
Collect.java \
@JAVA_JUNIT@

javapackage	= jjtraveler
javadir		= ${prefix}/classes/jjtraveler
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src

SUBDIRS		= util test reflective graph

JAVA_JUNIT = \
	TestAll.java \
	FailTest.java \
	IdentityTest.java \
	IfThenElseTest.java \
	LibraryTest.java \
	NestingDepthTest.java \
	OnceTopDownTest.java \
	TopDownUntilTest.java \
	DoWhileSuccessTest.java \
	OneTest.java \
	CollectTest.java


EXTRA_DIST	= package.html overview.html.src

java_packages	= jjtraveler $(patsubst %,jjtraveler.%, $(SUBDIRS))
java_dirs	= $(srcdir) $(patsubst %,$(srcdir)/%, $(SUBDIRS))
java_files	= $(wildcard $(patsubst %, %/*.java, $(java_dirs)))
java_test_files	= $(wildcard $(patsubst %, %/TestAll.java, $(java_dirs)) $(patsubst %, %/*Test.java, $(java_dirs)))
java_doc_files  = $(filter-out $(java_test_files), $(java_files))





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
DOCDIR=./doc

all-local: htmljava.stamp 

install-data-local: html-install 

clean-local: html-clean

htmljava.stamp: $(java_JAVA) overview.html
	mkdir -p ${DOCDIR}
	@JAVADOC@ -windowtitle "JJTraveler Documentation" \
	  -sourcepath ${JAVASRCROOT} -classpath ${CLASSPATH} \
	  -overview overview.html \
	  -use -private -d ${DOCDIR} \
	  $(java_packages)
	cp ${patsubst %,${srcdir}/%,${JAVA_JUNIT}} $(DOCDIR)/$(javapackage)
	echo timestamp > htmljava.stamp

html-install: htmljava.stamp
	$(mkinstalldirs) $(datadir)/JJTraveler/doc
	cp -r ${DOCDIR}/* $(datadir)/JJTraveler/doc

html-clean:
	rm -fr ${DOCDIR} htmljava.stamp overview.html	

echo-classpath:
	@echo ${CLASSPATH}

echo-%:
	@echo ${$*}



%: %.src
	sed s/__VERSION__/${VERSION}/g $< > $@
