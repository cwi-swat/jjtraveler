package jjtraveler.test;

import jjtraveler.*;

/** 
 * A class to represent a visting event: the fact that a visitable
 * node is visited by a particular visitor.
 */

public class Event {
 
    Visitor visitor;
    Visitable node;

    public Event(Visitor v, Visitable n) {
	visitor = v;
	node = n;
    }

    public String toString() {
	return visitor + ".visit(" + node + ")";
    }
}
