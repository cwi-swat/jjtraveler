package jjtraveler.util;

/* 
   ASTToGraph = TopDown(MkEdgesToKids)
   MkEdgesToKids = All(MkEdgeFromParent)
*/

import jjtraveler.*;

public class ASTToGraph extends TopDown {
    public ASTToGraph() {
	super(new MkEdgesToKids(new DotGraph()));
    }
    public ASTToGraph(Graph graph) {
	super(new MkEdgesToKids(graph));
    }

}
