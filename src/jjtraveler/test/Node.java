package jjtraveler.test;
import java.util.*;
import java.io.*;

public class Node implements jjtraveler.Visitable {

    Node[] kids;
    NodeLogger logger;
    int nodeID;

    static int nodeCounter = 0;
    static NodeLogger staticLogger = new NodeLogger();

    public static Node factory(Node[] kids) {
	Node result = new Node(kids, staticLogger, nodeCounter);
	nodeCounter++;
	return result;
    }

    public static void reset() {
	nodeCounter = 0;
	staticLogger = new NodeLogger();
    }

    public Node(Node[] kids, NodeLogger logger, int nodeID) {
	this.kids = kids;
	this.logger = logger;
	this.nodeID = nodeID;
    }

    public Node accept(NodeVisitor v) throws jjtraveler.VisitFailure {
	logger.log("Node.accept");
	return v.visitNode(this);
    }

    public int getChildCount() {
	logger.log("Node.getChildCount");
	return kids.length;
    }
    
    public jjtraveler.Visitable getChildAt(int i) {
	logger.log("Node.getChildAt");
	return kids[i];
    }
    
    public jjtraveler.Visitable setChildAt(int i, jjtraveler.Visitable child) {
	logger.log("Node.setChildAt");
	kids[i] = (Node) child;
	return this;
    }

    public NodeLogger getLogger() {
	return logger;
    }

    public String toString() {
	return "Node-" + nodeID;
    }
}
