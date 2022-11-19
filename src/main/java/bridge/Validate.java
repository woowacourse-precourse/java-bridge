package bridge;

public class Validate {

    public int validateLengthOfBridge(String lengthOfBridge) {
        validateIsDigit(lengthOfBridge);
        return 0;
    }

    private void validateIsDigit(String Number) {
        if (!Number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }


}
