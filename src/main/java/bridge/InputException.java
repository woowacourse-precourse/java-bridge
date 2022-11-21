package bridge;

public class InputException {

    public static void isCorrectBridgeLength(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void isCorrectMoving(String input) {
        if (input.equals('U') || input.equals('D')) {
            throw new IllegalArgumentException("'U', 'D'중 하나의 문자만 입력해 주세요.");
        }
    }

    public static void isCorrectRestartCommand(String input) {
        if (input.equals('R') || input.equals('Q')) {
            throw new IllegalArgumentException("'R', 'Q'중 하나의 문자만 입력해 주세요.");
        }
    }
}
