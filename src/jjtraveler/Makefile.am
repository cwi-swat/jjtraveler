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
BreadthFirst.java

javadir		= ${prefix}/classes/jjtraveler
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src

SUBDIRS		= util test

all-local: htmljava.stamp

install-data-local: html-install

clean-local: html-clean

htmljava.stamp: $(java_JAVA)
	mkdir -p ./doc
	@JAVADOC@ -windowtitle "JJTraveler Documentation" \
	  -sourcepath ${JAVASRCROOT} -classpath ${CLASSPATH} \
	  -use -private -d ./doc \
	  jjtraveler jjtraveler.util jjtraveler.test
	echo timestamp > htmljava.stamp

html-install: htmljava.stamp
	$(mkinstalldirs) $(datadir)/doc/jjtraveler
	cp -r ./doc/* $(datadir)/doc/jjtraveler

html-clean:
	rm -fr ./doc htmljava.stamp

echo-classpath:
	@echo ${CLASSPATH}
