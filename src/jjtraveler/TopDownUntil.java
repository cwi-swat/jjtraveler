package jjtraveler;

/**
 * <code>TopDownUntil(v) = Choice(v,All(TopDownUntil(v)))</code>
 * <p>
 * Visitor combinator with one visitor argument that tries to apply
 * this visitor in pre-order fashion to all nodes, until it succeeds.
 * Thus, traversal is cut off below the nodes where success occurs.
 * <p>
 * In the Stratego Library, a strategy alltd(s) is present, that
 * resembles this TopDownUntil(v) combinator.
 */

public class TopDownUntil extends Choice {

    /* Create a visitor that applies its argument v in topdown
     * fashion until it succeeds. Thus, traversal is cut off below
     * the nodes where v succeeds.
     */
    public TopDownUntil(Visitor v) {
	super(v,null);
	then = new All(this);
    }

}
