package jjtraveler.graph;

import jjtraveler.*;

/**
 * Visit all nodes in the given graph exactly once,
 * in a top down fashion.
 *
 * <p>
 * Test case documentation: 
 * <a href="WhileNotVisitedTest.java">WhileNotVisitedTest</a>
 */

public class WhileNotVisited extends DoWhileSuccess {

    /** 
     * Carry out action for all nodes in the graph.
     */
    public WhileNotVisited(Visitor action) {
	super( new Not( new Visited() ), action );
    }

}
