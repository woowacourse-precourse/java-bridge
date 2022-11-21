package bridge.model;

public class PassOrFail {

    private final boolean value;
    private final UpOrDown upOrDown;

    public PassOrFail(boolean value, UpOrDown upOrDown) {
        this.value = value;
        this.upOrDown = upOrDown;
    }

    public boolean getValue() {
        return value;
    }

    public UpOrDown getUpOrDown() {
        return upOrDown;
    }
}
