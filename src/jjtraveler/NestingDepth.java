package jjtraveler;

public class NestingDepth implements Visitor {

    Visitor nestingRecognizer;
    int nestingLevel;
    int maxNestingDepth;
    
    public NestingDepth(Visitor nestingRecognizer) {
	this.nestingRecognizer = nestingRecognizer;
	this.nestingLevel = 0;
	this.maxNestingDepth = 0;
    }

    public NestingDepth(Visitor nestingRecognizer, 
			int nestingLevel,
			int maxNestingDepth) {
	this.nestingRecognizer = nestingRecognizer;
	this.nestingLevel = nestingLevel;
	this.maxNestingDepth = maxNestingDepth;
    }

    public int getDepth() {
	return maxNestingDepth;
    }

    public Visitable visit(Visitable x) throws VisitFailure {
	try {
	    nestingRecognizer.visit(x);
            (new All(this)).visit(x);
	} catch (VisitFailure vf) {
	    // we did find a nesting construct.
	    
	    nestingLevel++;
	    maxNestingDepth = max(maxNestingDepth, nestingLevel);

	    NestingDepth deeper = new NestingDepth(nestingRecognizer, 
						   nestingLevel,
						   maxNestingDepth
						   );
	    (new All( deeper )).visit(x);
	    maxNestingDepth = deeper.maxNestingDepth;
	}
	return x;
    }

    public int max(int i1, int i2) {
	return (i1 > i2? i1: i2);
    }
}
