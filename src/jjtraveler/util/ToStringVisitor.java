package jjtraveler.util;

import jjtraveler.*;

public class ToStringVisitor extends VoidVisitor {
    protected String string = "[WARNING] ToStringVisitor has not been invoked";
    public static String doToString(Visitable visitable)
      throws VisitFailure {
	ToStringVisitor v = new ToStringVisitor();
	return v.visitableToString(visitable);
    }
    public String visitableToString(Visitable visitable) {
	voidVisit(visitable);
	return getString();
    }
	
    public void voidVisit(Visitable visitable) {
	string = visitable.toString();
    }
    public String getString() {
	return string;
    }
}
