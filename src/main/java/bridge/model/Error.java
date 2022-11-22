package bridge.model;

import bridge.model.Command;

public class Error {
    static final int minBridgeLength = 3;
    static final int maxBridgeLength = 20;

    public static void isNumber(String userInput) {
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void isStartZero(String userInput) {
        if (userInput.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 다리 길이가 0으로 시작되지 않아야 합니다.");
        }
    }

    public static void isValidNumber(int number) {
        if (number < minBridgeLength || number > maxBridgeLength) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void isValidFootHold(String userInput) {
        if (!userInput.equals(Command.UP.getValue()) && !userInput.equals(Command.DOWN.getValue())) {
            throw new IllegalArgumentException("[ERROR] U나 D를 입력해야 합니다.");
        }
    }

    public static void isValidCommand(String userInput) {
        if (!userInput.equals(Command.QUIT.getValue()) && !userInput.equals(Command.RESTART.getValue())) {
            throw new IllegalArgumentException("[ERROR] R이나 Q를 입력해야 합니다.");
        }
    }
}
