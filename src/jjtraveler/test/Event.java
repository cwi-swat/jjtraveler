package jjtraveler.test;

import jjtraveler.*;

/** A class to represent visting events, i.e.
 *  the fact that a certain Visitable node is visited by
 *  a particular Visitor.
 */

public class Event {
 
    Visitor visitor;
    Visitable node;

    public Event(Visitor v, Visitable n) {
	visitor = v;
	node = n;
    }

    public String toString() {
	String msg = visitor.getClass().getName() + ".visit(" + node.toString() + ")";
	return msg;
    }
   
}
