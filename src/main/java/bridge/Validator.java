package bridge;

public class Validator {

    public static void validateBridgesize(int size) throws IllegalArgumentException {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void validateMoving(String movingType) throws IllegalArgumentException {
        if (!movingType.equals("U") || !movingType.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동은 U 또는 D를 입력해야합니다.");
        }
    }

    public static void validateRestartButton(String restartButton) + {
        if (!restartButton.equals("R") || !restartButton.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 다시 시도는 Q 또는 R을 입력해야합니다.");
        }
    }

}
