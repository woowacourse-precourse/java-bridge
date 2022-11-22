package bridge.validator;

public class InputValidator {
    public static void checkBridgeSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void checkMovingDirection(String direction) {
        if ( (direction.equals('U') || direction.equals('D')) == false ) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D로 입력해야 합니다.");
        }
    }
}
