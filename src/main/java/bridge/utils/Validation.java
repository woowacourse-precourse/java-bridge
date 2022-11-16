package bridge.utils;

public class Validation {
    public static int validate(String bridgeSize) {
        int bridgeSizeNumber = validateNumber(bridgeSize);
        return validateSize(bridgeSizeNumber);
    }

    private static int validateSize(int bridgeSizeNumber) {
        try {
            if (bridgeSizeNumber < 3 || bridgeSizeNumber > 20) {
                throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하여야 합니다.");
            }
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

        return bridgeSizeNumber;
    }

    private static int validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException error) {
            System.out.println(error.getMessage());
        }
        return Integer.parseInt(bridgeSize);
    }
}
