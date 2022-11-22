package bridge.validator;

import bridge.Key;

public class TextValidator {
    private final static String MOVE_WAY_ERROR_MESSAGE = "[ERROR] 이동 방향은 U또는 D만 입력 가능합니다.";
    private final static String RETRY_ERROR_MESSAGE = "[ERROR] 재시작 여부는 R과 Q로만 입력할 수 있습니다.";
    public static void validateMoveWay(String input) {
        if (!input.equals(Key.U.getValue()) && !input.equals(Key.D.getValue())) {
            throw new IllegalArgumentException(MOVE_WAY_ERROR_MESSAGE);
        }
    }

    public static void validateRetry(String input) {
        if (!input.equals(Key.R.getValue()) && !input.equals(Key.Q.getValue())) {
            throw new IllegalArgumentException(RETRY_ERROR_MESSAGE);
        }
    }
}
