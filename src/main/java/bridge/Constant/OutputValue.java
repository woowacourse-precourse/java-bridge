package bridge.Constant;

public enum OutputValue {
    rightBlock("O"),
    wrongBlock("X");

    private final String block;

    OutputValue(String block) {
        this.block = block;
    }

    public String get() {
        return block;
    }
}