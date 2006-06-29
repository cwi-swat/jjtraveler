# $Id$

include $(top_srcdir)/java_make_rules

SUBDIRS	= scripts 

ACLOCAL_FLAGS = -I .

JARFILE = jjtraveler-${VERSION}.jar
JARFILE_ENV = JAR=${JARFILE}
JUNIT = ${top_srcdir}/jars/junit.jar
EXTERNAL_JARS = ${JUNIT}
JAVA_PACKAGES=jjtraveler,jjtraveler.graph,jjtraveler.reflective,jjtraveler.test

data_DATA = ${JARFILE}
noinst_SCRIPTS = ${PACKAGE}-${VERSION}.pkg

EXTRA_DIST = \
	reconf \
	package \
	acincludejava.m4 \
	build.xml \
	${JARFILE}

pkgdata_DATA = ${JARFILE}

${PACKAGE}-${VERSION}.pkg: package Makefile
	cp $< $@

CLEANFILES = ${PACKAGE}-${VERSION}.pkg

