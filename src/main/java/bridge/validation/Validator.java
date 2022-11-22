package bridge.validation;

public class Validator {

    public String validateBridgeSize(String bridgeSize) {
        validateBridgeSizeFormat(bridgeSize);
        validateBridgeSizeRange(bridgeSize, 3, 20);

        return bridgeSize;
    }

    public String validateBridgeSizeFormat(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return bridgeSize;
    }

    public void validateBridgeSizeRange(String bridgeSize, int startInclusive, int endInclusive) {
        int parsedBridgeSize = Integer.parseInt(bridgeSize);
        if (parsedBridgeSize < startInclusive || parsedBridgeSize > endInclusive) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
