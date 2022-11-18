package bridge.game;

public enum Result {
    NONE("   "),
    SUCCESS(" O "),
    FAIL(" X ");

    private final String print;

    Result(String print) {
        this.print = print;
    }

    @Override
    public String toString() {
        return print;
    }
}
