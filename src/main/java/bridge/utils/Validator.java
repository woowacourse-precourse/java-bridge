package bridge.utils;

public class Validator {
    public static void checkLengthInput(int length) {
        if (length < 3 || length > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void checkMovingInput(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸 입력은 U 또는 D여야 합니다.");
        }
    }
}
