package jjtraveler.test;

import java.util.*;
import jjtraveler.*;

public class Logger {

    Vector trace = new Vector();

    public Logger() {};

    public Logger (Visitor v, Visitable[] nodes) {
	for (int i = 0; i < nodes.length; i++) {
	    log( new Event(v, nodes[i]) );
	}
    }

    public void log( Event e ) {
	trace.add( e );
    }
	
    public String toString() {
	String result = "";
	for (Enumeration e = trace.elements() ; e.hasMoreElements() ;) {
	    result += e.nextElement().toString() + "\n";
	}
	return result;
    }
       
    public boolean equals(Object o) {
	if (o instanceof Logger) {
	    return ( (Logger) o).toString().equals(toString());
	} else {
	    return false;
	}
    }
	

}
