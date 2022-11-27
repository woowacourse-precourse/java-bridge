package bridge.type;

public enum ResultType {
    SUCCESS("성공", "O"),
    FAIL("실패", "X"),
    BLANK("공백", " ");

    private final String state;
    private final String shape;

    ResultType(String state, String shape) {
        this.state = state;
        this.shape = shape;
    }

    public String getState() {
        return this.state;
    }

    public String getShape() {
        return this.shape;
    }
}