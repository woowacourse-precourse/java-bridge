package bridge;

public class Error {
    static final int minBridgeLength = 3;
    static final int maxBridgeLength = 20;

    static void isNumber(String userInput) {
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }

    static void isValidNumber(int number) {
        if (number < minBridgeLength || number < maxBridgeLength) {
            throw new IllegalArgumentException("[ERROR] 3에서 20 사이의 숫자를 입력해야 합니다.");
        }
    }

    static void isValidFootHold(String userInput) {
        if (userInput != Command.UP.getValue() || userInput != Command.DOWN.getValue()) {
            throw new IllegalArgumentException("[ERROR] U나 D를 입력해야 합니다.");
        }
    }

    static void isValidCommand(String userInput) {
        if (userInput != Command.QUIT.getValue() || userInput != Command.RESTART.getValue()) {
            throw new IllegalArgumentException("[ERROR] R이나 Q를 입력해야 합니다.");
        }
    }
}
