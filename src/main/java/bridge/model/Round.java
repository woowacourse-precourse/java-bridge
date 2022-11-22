package bridge.model;

public class Round {

    private final Direction selection;
    private final boolean pass;

    public Round(Direction selection, boolean pass) {
        this.selection = selection;
        this.pass = pass;
    }

    public Direction getSelection() {
        return selection;
    }

    public boolean isPass() {
        return pass;
    }
}
