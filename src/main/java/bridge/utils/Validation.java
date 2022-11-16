package bridge.utils;

public class Validation {
    public static int validate(String bridgeSize) {
        int bridge = validateNumber(bridgeSize);
        return validateSize(bridge);
    }

    private static int validateSize(int bridgeSize) {
        try {
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하여야 합니다.");
            }
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        return bridgeSize;
    }

    private static int validateNumber(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }
}
