package jjtraveler;

/**
 * <code>TopDownUntil(v) = Choice(Sequence(v,All(TopDownUntil(v))),Identity)</code>
 * <p>
 * Visitor combinator with one visitor argument that applies this
 * visitor in pre-order fashion to all nodes, until it fails. Thus,
 * traversal is cut off below the nodes where failure occurs.
 */

public class TopDownUntil extends Choice {

    /* Create a visitor that applies its argument v in topdown
     * fashion until it fails. Thus, traversal is cut off below
     * the nodes where v fails.
     */
    public TopDownUntil(Visitor v) {
	super(null,
	      new Identity());
	first = new Sequence(v,new All(this));
    }

    /* Create a visitor that applies its argument v in topdown
     * fashion until it fails, and subsequently applies its argument
     * vFinally at the nodes where failure occurs.
     */
    public TopDownUntil(Visitor v, Visitor vFinally) {
	super(null,
	      vFinally);
	first = new Sequence(v,new All(this));
    }

}
