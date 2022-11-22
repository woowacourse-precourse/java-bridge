package bridge.validator;

public class Validate {

    public static void validateBridgeSizeNumber(String bridgeSizeInput) {
        int number = Integer.parseInt(bridgeSizeInput);
        validateBetweenNumber(number);
        for (int i = 0; i < bridgeSizeInput.length(); i++) {
            if (!Character.isDigit(bridgeSizeInput.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

    }
    public static void validateCheckRetry(String command) {
        if (!command.equals("Q") && !command.equals("R")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCheckMove(String userMove) {
        if (!userMove.equals("U") && !userMove.equals("D")) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateBetweenNumber(int number) {
        if (!(number <= 20 && number >= 3)) {
            throw new IllegalArgumentException();
        }
    }
}
