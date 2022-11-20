package bridge;

/**
 * 사용자로부터 입력 받은 값을 검증하는 역할을 한다.
 */
public class Validation {
    public boolean isCheckNotDigit(String input) {
        return !input.matches("[0-9]+");
    }

    public void validateBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException();
        }
    }
}
