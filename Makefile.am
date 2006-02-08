# $Id$

SUBDIRS	= scripts

ACLOCAL_FLAGS = -I .

JARFILE = jjtraveler-${VERSION}.jar
JARFILE_ENV = JAR=${JARFILE}
JUNIT = ${top_srcdir}/jars/junit.jar
ANT_ENV = JARS=${EXTERNAL_JARS}:${JUNIT} CLASSPATH=${JUNIT}
PACKAGE_VERSION = PKG_VERSION=${VERSION}

data_DATA = ${JARFILE}
noinst_SCRIPTS = ${PACKAGE}-${VERSION}.pkg

EXTRA_DIST = \
	reconf \
	package \
	acincludejava.m4 \
	build.xml \
	${JARFILE}

${PACKAGE}-${VERSION}.pkg: package Makefile
	cp $< $@

CLEANFILES = ${PACKAGE}-${VERSION}.pkg

if MAINTAINER_MODE
${JARFILE}:
	${ANT_ENV} ${JARFILE_ENV} ant dist

check:
	${ANT_ENV} ${JARFILE_ENV} ant check

doc:
	${ANT_ENV} ${PACKAGE_VERSION} ant doc

clean-local:
	${JARFILE_ENV} ant clean
endif
