package jjtraveler.test;

import java.util.*;
import jjtraveler.*;

public class Logger {

    Vector trace = new Vector();

    public Logger() {};

    public Logger (Visitor v, Visitable[] nodes) {
	for (int i = 0; i < nodes.length; i++) {
	    log( Event.makeVisitEvent(v, nodes[i]) );
	}
    }

    public void log(String msg) {
	log( new Event( msg ) );
    }

    public void log( Event e ) {
	trace.add( e );
    }
	

    public String getTrace() {
	return toString();
    }

    public String toString() {
	String result = "";
	for (Enumeration e = trace.elements() ; e.hasMoreElements() ;) {
	    result += e.nextElement().toString();
	}
	return result;
    }
       

    public void reset() {
	trace = new Vector();
    }

    public boolean equals(Object o) {
	if (o instanceof Logger) {
	    return ( (Logger) o).getTrace().equals(toString());
	} else {
	    return false;
	}
    }
	

}
