package bridge;

public class Validate {

    public int validateLengthOfBridge(String lengthOfBridge) {
        validateIsDigit(lengthOfBridge);
        return validateRangeOfLength(lengthOfBridge);
    }

    private void validateIsDigit(String number) {
        if (!number.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }

    private int validateRangeOfLength(String number) {
        int lengthOfBridge = Integer.parseInt(number);
        if (lengthOfBridge > 20 || lengthOfBridge < 3) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 3이상 20이하여야 합니다.");
        }
        return lengthOfBridge;
    }


}
