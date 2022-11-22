package bridge.view.constant;

public enum MoveOptions {
    UP("U"),
    DOWN("D");

    private final String option;

    private MoveOptions (String option) {
        this.option = option;
    }

    public String get() {
        return option;
    }
}
