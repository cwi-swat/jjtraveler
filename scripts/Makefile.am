bin_SCRIPTS = jjtraveler-config

CLEANFILES = jjtraveler-config

EXTRA_DIST = jjtraveler-config.sh.src

% : %.sh.src Makefile
	sed 's@__PREFIX__@${prefix}@g;\
             s@__VERSION__@${VERSION}@g;' < $< > $@ && chmod +x $@
