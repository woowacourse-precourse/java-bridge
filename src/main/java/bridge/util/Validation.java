package bridge.util;

/**
 * 사용자로부터 입력 받은 값을 검증하는 역할을 한다.
 */
public class Validation {
    public boolean isCheckNotDigit(String bridgeSize) {
        return !bridgeSize.matches("[0-9]+");
    }

    public void validateBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }

    public String validateNumber(int number) {
        if (number == 0) {
            return "D";
        }
        return "U";
    }

    public void validateMove(String move) throws IllegalArgumentException {
        if (!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCommand(String command) throws IllegalArgumentException {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException();
        }
    }
}
