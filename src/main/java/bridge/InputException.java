package bridge;

public class InputException {

    public static void isCorrectBridgeInput(String input) {
        isNumber(input);
        isCorrectBridgeLength(input);
    }

    public static void isCorrectBridgeLength(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }

    public static void isCorrectMoving(String input) {
        if (!(input.contains("U") || input.contains("D") || input.contains("u") || input.contains("d") )) {
            throw new IllegalArgumentException("'U', 'D'중 하나의 문자만 입력해 주세요.");
        }
    }

    public static void isCorrectRestartCommand(String input) {
        if (!(input.contains("R") || input.contains("Q") || input.contains("r") || input.contains("q"))) {
            throw new IllegalArgumentException("'R', 'Q'중 하나의 문자만 입력해 주세요.");
        }
    }
}
