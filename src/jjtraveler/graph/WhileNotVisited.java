package jjtraveler.graph;

import jjtraveler.*;

/**
 * Visit all nodes in the given graph exactly once,
 * in a top down fashion.
 */

public class WhileNotVisited extends DoWhileSuccess {

    /** 
     * Carry out action for all nodes in the graph.
     */
    public WhileNotVisited(Visitor action) {
	super( new Not( new Visited() ), action );
    }

}
