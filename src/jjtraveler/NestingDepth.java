package jjtraveler;

/**
 * Counter of the number of nested occurrences of a construct
 * recognized by the argument visitor on a single given path.
 *
 * A typical example of its usage is for counting the
 * maximum nesting level of if-statements in a program.
 */
public class NestingDepth implements Visitor, Cloneable {

    Visitor nestingRecognizer;
    Visitor goOnWhileSuccess = new Identity();
    int nestingLevel = 0;
    int maxNestingDepth = 0;
    
    /** Create a nesting counter given the recognizer argument.
     *  The recognizer fails at all nodes, except for the ones
     *  recognized, at which it succeeds.
     */
    public NestingDepth(Visitor nestingRecognizer, Visitor goOn) {
	this.nestingRecognizer = nestingRecognizer;
	this.goOnWhileSuccess = goOn;
    }

   /** Create a nesting counter given the recognizer argument.
     */
    public NestingDepth(Visitor nestingRecognizer) {
	this.nestingRecognizer = nestingRecognizer;
    }

    /** Restart a visitor after having recognized a relevant construct.
     */
    private NestingDepth restart() {
	NestingDepth nextDepth = (NestingDepth) this.clone();
	nextDepth.maxNestingDepth = max(maxNestingDepth, nestingLevel + 1);
	nextDepth.nestingLevel++;
	return nextDepth;
    }

    public Object clone() {
	NestingDepth theClone = 
	    new NestingDepth(nestingRecognizer, goOnWhileSuccess);
	theClone.nestingLevel = nestingLevel;
	theClone.maxNestingDepth = maxNestingDepth;
	return theClone;
    }

    private NestingDepth apply(Visitable x) {
	(new GuaranteeSuccess (new All(this))).visit(x);
	return this;
    }

    /** Return the maximum nesting depth found.
     */
    public int getDepth() {
	return maxNestingDepth;
    }

    /** Apply the nesting depth counter to a given visitable.
     */
    public Visitable visit(Visitable x) throws VisitFailure {
	try {
	    goOnWhileSuccess.visit(x);
	    // all is fine -- we'll continue below;
	} catch (VisitFailure stopNow) {
	    return x; 
	}

	// we can continue searching for nested constructs.
	try {
	    nestingRecognizer.visit(x);
	    maxNestingDepth = restart().apply(x).getDepth();
	} 
	catch (VisitFailure noNestingConstructFound) {
	    this.apply(x);
	}
	return x;
    }

    /** Status printing that can be used for debugging purposes.
     */
    private String status() {
	return " maxNestingDepth = " + maxNestingDepth + "; " +
	    "nestingLevel = " + nestingLevel;
    }

    /** Where is this one in the Java API?
     */
    private int max(int i1, int i2) {
	return (i1 > i2? i1: i2);
    }
}
