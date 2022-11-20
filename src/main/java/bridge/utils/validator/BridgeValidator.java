package bridge.utils.validator;

public class BridgeValidator {

    public static void validSize(String bridgeSize) {
        int size = isNumber(bridgeSize);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20 이하의 숫자만 가능합니다");
        }
    }

    private static int isNumber(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자만 입력 가능합니다");
        }
    }
}
