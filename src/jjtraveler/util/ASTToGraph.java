package jjtraveler.util;

/**
 * <code>ASTToGraph 
 *       = TopDown(MkEdgesToKids)</code>
 * <p>
 * Creates a graph representation from a given object graph.
 */

import jjtraveler.*;

public class ASTToGraph extends TopDown {
    /**
     * Create a visitor that adds edges to the given graph.
     */
    public ASTToGraph(Graph graph) {
	super(new MkEdgesToKids(graph));
    }
}
