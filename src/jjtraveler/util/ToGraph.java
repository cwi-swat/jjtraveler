package jjtraveler.util;

/**
 * <code>ToGraph(isNode)
 *       = TopDownUntil(Sequence(isNode,MkEdgesToKids(ToGraph(isNode))))</code>
 * <p>
 *
 * Creates a graph representation from a given object graph, where
 * <code>isNode</code> determines for which objects a node is generated.
 */

import jjtraveler.*;

public class ToGraph extends TopDownUntil {

    public ToGraph(Graph graph, Visitor isNode) {
	super(null);
	Visitor nodeAction
	    = new Sequence(isNode, 
			   new MkEdgesToKids(graph,
					     new Sequence(isNode,this)));
	setArgument(nodeAction);
    }
}
