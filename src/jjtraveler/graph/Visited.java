package jjtraveler.graph;

import jjtraveler.*;
import java.util.*;

/**
 * Checks whether it has previously visited the current visitable.
 * If not, it will remember the current visitable, and then fail.
 */

public class Visited extends VoidVisitor {

    Set visited = new HashSet();

    /**
     * Create with an initially empty collection of nodes that have
     * already been visited.
     */
    public Visited() {}

    /**
     * Create with initial collection of nodes that have already been
     * visited.
     */
    public Visited(Collection visited) {
	this.visited = new HashSet(visited);
    }

    public void voidVisit(Visitable x)
      throws VisitFailure {
	if (!visited.contains(x)) {
	    visited.add(x);
	    throw new VisitFailure();
	}
    }

    /**
     * Return collection of visitables visited so far.
     */
    public Collection getVisited() {
	return visited;
    }
}
