package jjtraveler.graph;

import jjtraveler.*;

public class WhileNotVisited extends DoWhileSuccess {

    public WhileNotVisited(Visitor action) {
	super( new Not( new Visited() ), action );
    }

}
