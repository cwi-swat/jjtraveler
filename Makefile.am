# $Id$

SUBDIRS	= scripts

ACLOCAL_FLAGS = -I .

JARFILE = jjtraveler-${VERSION}.jar
JARFILE_ENV = JAR=${JARFILE}
JARS_ENV = JARS=${EXTERNAL_JARS}:${top_srcdir}/jars/junit.jar

data_DATA = ${JARFILE}
noinst_SCRIPTS = ${PACKAGE}-${VERSION}.pkg

EXTRA_DIST = reconf package acincludejava.m4 build.xml ${JARFILE}

${PACKAGE}-${VERSION}.pkg: package Makefile
	cp $< $@

CLEANFILES = ${PACKAGE}-${VERSION}.pkg

check:
	${JARS_ENV} ${JARFILE_ENV} ant check

if MAINTAINER_MODE
${JARFILE}:
	${JARS_ENV} ${JARFILE_ENV} ant dist

doc:
	${JARS_ENV} ant doc

clean-local:
	${JARFILE_ENV} ant clean
endif
