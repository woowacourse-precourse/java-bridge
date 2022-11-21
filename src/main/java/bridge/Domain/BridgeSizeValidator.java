package bridge.Domain;

public class BridgeSizeValidator {
    private final int bridgeSize;

    public BridgeSizeValidator(String bridgeSize) {
        validate(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }
    private void validate(String bridgeSize) {
        canConvertToNumber(bridgeSize);
        isInRange(bridgeSize);
    }

    private void canConvertToNumber(String bridgeSize) {
        try {
            int number = Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 입력만 가능합니다.");
        }
    }

    private void isInRange(String bridgeSize) {
        int number = Integer.parseInt(bridgeSize);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
