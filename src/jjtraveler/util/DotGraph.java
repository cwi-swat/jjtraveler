package jjtraveler.util;

import jjtraveler.*;

public class DotGraph implements Graph {
    String edges = "";
    public void addEdge(Visitable from, Visitable to) {
	String edge = from+" -> "+to+";\n";
	edges += edge;
    }
    public String printGraph(String name) {
	String result = "digraph "+name+" {\n";
	result += edges;
	result += "}\n";
	return result;
    }
}
