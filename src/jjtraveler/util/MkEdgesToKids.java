package jjtraveler.util;

import jjtraveler.*;

public class MkEdgesToKids extends VoidVisitor {
    Graph graph;
    public MkEdgesToKids(Graph graph) {
	this.graph = graph;
    }

    public void voidVisit(Visitable parent)
      throws jjtraveler.VisitFailure {
	Visitor v = new All(new MkEdgeFromParent(parent,graph));
	v.visit(parent);
    }
}
