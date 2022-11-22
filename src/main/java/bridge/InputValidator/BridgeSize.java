package bridge.InputValidator;

public class BridgeSize {
    private int bridgeSize;

    public BridgeSize(String bridgeSize) {
        this.bridgeSize = toInteger(bridgeSize);
        validateRange();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    private int toInteger(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }

    private void validateRange() {
        if (this.bridgeSize < 3 || this.bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3 이상 20 이하의 숫자가 들어가야 합니다.");
        }
    }
}
