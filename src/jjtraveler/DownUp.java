package jjtraveler;

/**
 * <code>DownUp(down,up) = Sequence(down,Sequence(All(DownUp(down,up)),up))</code>
 * <p>
 * <code>DownUp(down,stop,up) = Sequence(down,Sequence(Choice(stop,All(DownUp(down,up))),up))</code>
 */

public class DownUp extends Sequence {

    public DownUp(Visitor down, Visitor up) {
	super(down, null);
	then = new Sequence(new All(this), up);
    }

    public DownUp(Visitor down, Visitor stop, Visitor up) {
	super(down, null);
	then = new Sequence(new Choice(stop,new All(this)), up);
    }

}
