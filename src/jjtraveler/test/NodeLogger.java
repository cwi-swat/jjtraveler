package jjtraveler.test;

public class NodeLogger {

    String trace = "";

    public void log(String msg) {
	trace += msg;
	System.out.println(msg);
    }

    public String getTrace() {
	return trace;
    }

    public void reset() {
	trace = "";
    }

}
