package jjtraveler;

/**
 * Counter of the number of nested occurrences of a construct
 * recognized by the argument visitor on a single given path.
 *
 * A typical example of its usage is for counting the
 * maximum nesting level of if-statements in a program.
 */
public class NestingDepth implements Visitor {

    Visitor nestingRecognizer;
    Visitor goOnWhileSuccess;
    int nestingLevel;
    int maxNestingDepth;
    
    /** Create a nesting counter given the recognizer argument.
     *  The recognizer fails at all nodes, except for the ones
     *  recognized, at which it succeeds.
     */
    public NestingDepth(Visitor nestingRecognizer, Visitor goOn) {
	this.nestingRecognizer = nestingRecognizer;
	this.goOnWhileSuccess = goOn;
	this.nestingLevel = 0;
	this.maxNestingDepth = 0;
    }

   /** Create a nesting counter given the recognizer argument.
     */
    public NestingDepth(Visitor nestingRecognizer) {
	this.nestingRecognizer = nestingRecognizer;
	this.goOnWhileSuccess = new Identity();
	this.nestingLevel = 0;
	this.maxNestingDepth = 0;
    }

    /** Internal constructor used for restarting the counter
     *  with a new current nesting level and maximum found so far.
     */
    NestingDepth(Visitor nestingRecognizer, 
		 int nestingLevel,
		 int maxNestingDepth,
		 Visitor goOn) {
	this.nestingRecognizer = nestingRecognizer;
	this.nestingLevel = nestingLevel;
	this.maxNestingDepth = maxNestingDepth;
	this.goOnWhileSuccess = goOn;
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
	    NestingDepth deeper = 
		new NestingDepth(nestingRecognizer, 
				 nestingLevel + 1,
				 max(maxNestingDepth, nestingLevel + 1),
				 goOnWhileSuccess
				 );
	    (new All( deeper )).visit(x);
	    maxNestingDepth = deeper.getDepth();
	} 
	catch (VisitFailure noNestingConstructFound) {
	    (new All(this)).visit(x);
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
