package jjtraveler.util;

import jjtraveler.*;
import java.util.*;

public class EdgesGraph implements Graph {
    Set edges = new HashSet();

    public void addEdge(Visitable from, Visitable to) {
	Edge edge = new Edge(from,to);
	edges.add(edge);
    }
    public String toDot(String name) {
	String result = "digraph "+name+" {\n";
	Iterator edgeIterator = edges.iterator();
	while (edgeIterator.hasNext()) {
	    Edge edge = (Edge) edgeIterator.next();
	    result += edge.toDot();
	}
	result += "}\n";
	return result;
    }
    public String toRSF() {
	String result = "";
	Iterator edgeIterator = edges.iterator();
	while (edgeIterator.hasNext()) {
	    Edge edge = (Edge) edgeIterator.next();
	    result += edge.toRSF();
	}
	return result;
    }
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof EdgesGraph) {
            EdgesGraph g = (EdgesGraph) o;
            result = g.edges.equals(edges);
        }
        return result;
    }
    public int hashCode() {
	int result = super.hashCode();
	Iterator edgeIterator = edges.iterator();
	while (edgeIterator.hasNext()) {
	    Edge edge = (Edge) edgeIterator.next();
	    result += edge.hashCode();
	}
	return result;
    }

    class Edge {
	Visitable source;
	Visitable target;
	public Edge(Visitable source, Visitable target) {
	    this.source = source;
	    this.target = target;
	}
	public String toDot() {
	    return source+" -> "+target+";\n";
	}
	public String toRSF() {
	    return "edge "+source+" "+target+";\n";
	}
	public boolean equals(Object o) {
	    boolean result = false;
	    if (o instanceof Edge) {
		Edge edge = (Edge) o;
		result = edge.source.equals(source) && edge.target.equals(target);
	    }
	    return result;
	}
	public int hashCode() {
	    return source.hashCode() + target.hashCode();
	}
    }
}
