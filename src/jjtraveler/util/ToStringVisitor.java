package jjtraveler.util;

import jjtraveler.*;

public class ToStringVisitor extends VoidVisitor {
    private String string = "[WARNING] ToStringVisitor has not been invoked";
    public static String doToString(Visitable visitable)
      throws VisitFailure {
	ToStringVisitor v = new ToStringVisitor();
	v.visit(visitable);
	return v.getString();
    }
    public void voidVisit(Visitable visitable) {
	string = visitable.toString();
    }
    public String getString() {
	return string;
    }
}
