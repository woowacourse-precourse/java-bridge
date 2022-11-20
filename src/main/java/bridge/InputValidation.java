package bridge;

public class InputValidation {

    static final int bridgeSizeStart = 3;
    static final int bridgeSizeEnd = 20;

    public void readBridgeSizeValidation(int size) {
        if (size < bridgeSizeStart || size > bridgeSizeEnd) {
            throw new IllegalArgumentException();
        }
    }

    public String readMovingValidation(String move) {
        return null;
    }

    public String readGameCommandValidation(String command) {
        return null;
    }
}
