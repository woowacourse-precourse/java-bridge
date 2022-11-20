package bridge;

public class InputValidation {

    static final int bridgeSizeStart = 3;
    static final int bridgeSizeEnd = 20;

    public void readBridgeSizeValidation(int size) {
        if (size < bridgeSizeStart || size > bridgeSizeEnd) {
            throw new IllegalArgumentException();
        }
    }

    public void readMovingValidation(String move) {
        if (!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException();
        }
    }

    public void readGameCommandValidation(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException();
        }
    }
}
