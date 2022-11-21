package bridge.utils;

public class Validator {
    public static void checkSizeInRange(int size) {
        if (3 > size || size > 20) {
            throw new IllegalArgumentException("3 이상 20 이하의 숫자만 입력가능합니다");
        }
    }

    public static void checkMoveInput(String moveInput) {
        if(!MoveFormat.MOVE_UP.isEqual(moveInput) && !MoveFormat.MOVE_DOWN.isEqual(moveInput)) {
            throw new IllegalArgumentException("보기에 있는 값만 입력 가능합니다.");
        }
    }

    public static void checkRetryInput(String retryInput) {
        if(!RetryFormat.RETRY.isEqual(retryInput) && !RetryFormat.QUIT.isEqual(retryInput)) {
            throw new IllegalArgumentException("보기에 있는 값만 입력 가능합니다.");
        }
    }
}
