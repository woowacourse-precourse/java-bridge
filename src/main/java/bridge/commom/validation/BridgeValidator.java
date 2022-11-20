package bridge.commom.validation;

public class BridgeValidator {

    public static void isProperlyBridgeSize(int size) {
        if (size < 3 || 20 < size) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
