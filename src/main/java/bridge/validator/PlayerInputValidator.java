package bridge.validator;

public class PlayerInputValidator {
    public static void bridgeLengthValidator(int length) {
        if (!(3 <= length && length <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void moveBridgeInputValidator(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동하기 위해서는 U 또는 D만 입력해야 합니다.");
        }
    }

    public static void restartOrEndInputValidator(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 재시작 여부는 R 또는 Q만 입력해야 합니다.");
        }
    }
}
