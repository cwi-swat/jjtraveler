package jjtraveler.test;

import jjtraveler.*;

public class Event {
 
    String msg;

    public Event (String m ) {
	msg = m;
    }

    public static Event makeVisitEvent(Visitor v, Visitable n) {
	String visitorName = v.getClass().getName();
	return new Event( visitorName +".visit(" + n + ")" );
    }

    public String toString() {
	return msg;
    }
   
}
