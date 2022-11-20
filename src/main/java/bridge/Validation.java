package bridge;

public class Validation {

    // 다리의 길이를 검증하는 기능
    public static void validateBridgeSize(String enteredBridgeSize) {
        isDigit(enteredBridgeSize);
        int bridgeSize = Integer.parseInt(enteredBridgeSize);
        isInRange(bridgeSize);
    }

    // 입력받은 값이 숫자인지 검증하는 기능
    public static void isDigit(String bridgeSize) {
        for (char c : bridgeSize.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
    }

    // 숫자가 맞다면 3~20사이의 숫자인지 검증하는 기능
    public static void isInRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 3~20사이의 숫자만 입력해 주세요.");
        }
    }
}
