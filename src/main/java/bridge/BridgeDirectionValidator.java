package bridge;

public class BridgeDirectionValidator {
    private final String bridgeDirection;

    public BridgeDirectionValidator(String bridgeDirection) {
        validate(bridgeDirection);
        this.bridgeDirection = bridgeDirection;
    }

    private void validate(String bridgeSize) {
        if (!bridgeSize.equals("U") && !bridgeSize.equals("D")) {
            throw new IllegalArgumentException("[ERROR] \"U\" 또는 \"D\"를 입력해야 합니다.");
        }
    }

    public String getBridgeDirection() {
        return bridgeDirection;
    }
}
