package jjtraveler.test;
import junit.framework.*;
import jjtraveler.*;


/** This extension of TestCase can be used to
  * test generic traversals as occurring, for instance
  * in the the jjtraveler visitor combinator library.
  */

public abstract class VisitorTestCase extends TestCase 
{

    /** 
     * Nodes in a simple tree that can be used for
     * testing traversals.
     * Names correspond to paths in the tree:
     * <pre>
     *        n0
     *      /    \
     *    n1     n2
     *    / \    
     * n11  n12
     * </pre>
     */
    Node n0;
    Node n1;
    Node n2;
    Node n11;
    Node n12;

    public Node buildTree() {
	n11 = new Node();
	n12 = new Node();
	n2  = new Node();
	n1  = new Node(new Node[]{n11,n12});
	n0  = new Node(new Node[]{n1,n2});
	return n0;
    }

    public Logger logger;

    protected void setUp() {
	Node.reset();
	buildTree();
	logger = new Logger();
    }

    /** Many test cases will need a logging visitor:
     * this methods returns one.
     */
    public LogVisitor logVisitor(Visitor v) {
	return new LogVisitor(v, logger);
    }

    public VisitorTestCase(String name) {
	super(name);
    }
}



