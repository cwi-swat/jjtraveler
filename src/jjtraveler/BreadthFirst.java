package jjtraveler;

import java.util.LinkedList;

public class BreadthFirst {

    public BreadthFirst(Visitor v) {
	pending = new LinkedList();
	this.v = v;
    }

    LinkedList pending;
    Visitor v;

    public Visitable visit(Visitable x)
      throws VisitFailure {
	Visitable result = v.visit(x);
	int childCount = result.getChildCount();

        for (int i = 0; i < childCount; i++) {
            pending.addLast(x.getChildAt(i));
        }

	if (pending.size() != 0) {
	    result = (Visitable) pending.removeFirst();
	    result = this.visit(result);
	}

        return result;
    }
}
	
