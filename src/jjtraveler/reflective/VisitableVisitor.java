package jjtraveler.reflective;

import jjtraveler.Visitor;
import jjtraveler.Visitable;

/**
 * A visitor that it iself visitable with a VisitorVisitor needs
 * to implement the VisitableVisitor interface. The visitor's arguments
 * should play the role of children.
 */

public interface VisitableVisitor extends Visitable, Visitor {

}
