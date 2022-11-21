package bridge;

public class Round {

    private Direction selection;
    private boolean pass;

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
