SUBDIRS=@JJT_TESTS@
DIST_SUBDIRS=test

DOCDIR		= ../doc
javapackage	= jjtraveler.reflective
packagedir	= jjtraveler/reflective
javadir		= $(prefix)/classes/$(packagedir)
JAVAROOT	= ${top_builddir}/src
JAVASRCROOT	= ${top_srcdir}/src

EXTRA_DIST = ${java_JAVA} package.html

java_JAVA = \
	VisitableFail.java \
	VisitableIdentity.java \
	VisitableSequence.java \
	VisitableVisitor.java \
	VisitorFwd.java \
	VisitorVisitor.java \
	WrapLog.java
