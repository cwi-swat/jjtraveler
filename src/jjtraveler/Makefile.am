javapackage	= jjtraveler
javadir		= ${prefix}/classes/jjtraveler
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src

SUBDIRS		= util reflective graph

EXTRA_DIST = \
	${java_JAVA} \
	${EXTRA_JAVA} \
	package.html \
	overview.html.src


java_packages	= jjtraveler $(patsubst %,jjtraveler.%, $(SUBDIRS))
java_dirs	= $(srcdir) $(patsubst %,$(srcdir)/%, $(SUBDIRS))
java_files	= $(wildcard $(patsubst %, %/*.java, $(java_dirs)))
java_test_files	= $(wildcard $(patsubst %, %/TestAll.java, $(java_dirs)) $(patsubst %, %/*Test.java, $(java_dirs)))
java_doc_files  = $(filter-out $(java_test_files), $(java_files))


# Creating the javadocs
DOCDIR=./doc

# all-local: htmljava.stamp 

#install-data-local: html-install 

clean-local: html-clean

htmljava.stamp: $(java_JAVA) overview.html
	mkdir -p ${DOCDIR}
	@JAVADOC@ -windowtitle "JJTraveler Documentation" \
	  -sourcepath ${JAVASRCROOT} -classpath ${CLASSPATH} \
	  -overview overview.html \
	  -use -private -d ${DOCDIR} \
	  $(java_packages)
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

java_JAVA = \
	All.java \
	AllSpinesBottomUp.java \
	Backtrack.java \
	BottomUp.java \
	BreadthFirst.java \
	BreadthFirstWhile.java \
	Child.java \
	Choice.java \
	Collect.java \
	Collector.java \
	DefUse.java \
	DefinedCombinator.java \
	Descendant.java \
	DoWhileSuccess.java \
	DownUp.java \
	Fail.java \
	GuaranteeSuccess.java \
	Identity.java \
	IfThenElse.java \
	NestingDepth.java \
	Not.java \
	OnceBottomUp.java \
	OnceBreadthFirst.java \
	OnceTopDown.java \
	One.java \
	Sequence.java \
	Some.java \
	SpineBottomUp.java \
	SpineTopDown.java \
	StateVisitor.java \
	SuccessCounter.java \
	TopDown.java \
	TopDownUntil.java \
	TopDownWhile.java \
	Try.java \
	VisitFailure.java \
	Visitable.java \
	VisitableList.java \
	Visitor.java \
	VoidVisitor.java
	Node.java \
	NodeVisitor.java\
	Logger.java \
	LogVisitor.java \
	Event.java \
	VisitorTestCase.java \
	FailAtNodes.java \
	SucceedAtNodes.java \
	TimeLogVisitor.java 

JAVA_JUNIT = \
	FailAtNodesTest.java\
	TestAll.java\
	LoggerTest.java\
	TimeLogVisitorTest.java \
	AllSpinesBottomUpTest.java \
	AllTest.java \
	FailTest.java \
	IdentityTest.java \
	IfThenElseTest.java \
	LibraryTest.java \
	NestingDepthTest.java \
	OnceTopDownTest.java \
	SpineTopDownTest.java \
	SomeTest.java \
	SpineBottomUpTest.java \
	TopDownUntilTest.java \
	DoWhileSuccessTest.java \
	OneTest.java \
	SuccessCounterTest.java \
	CollectTest.java \
	ChildTest.java \
	DescendantTest.java 

EXTRA_JAVA  = $(JAVA_JUNIT)

TESTS_JUNIT = MainTest 

TESTS       = @TESTS_JUNIT@

EXTRA_TESTS = $(TESTS_JUNIT)

MainTest: Makefile
	echo "#! /bin/sh" > $@
	echo "@JUNIT@ jjtraveler.test.TestAll" >> $@
	chmod +x $@

CLEANFILES=MainTest
