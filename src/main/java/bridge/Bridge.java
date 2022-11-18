package bridge;

import static bridge.MessageUtil.INVALID_BRIDGE_SIZE;

import java.util.List;

public class Bridge {
    private static final int SIZE_LIMIT_START = 3;
    private static final int SIZE_LIMIT_END = 20;

    private final int bridgeSize;
    private List<String> bridge;

    public Bridge(String bridgeSize) {
        validateBridgeSize(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
        requestNewBridge();
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!isNumeric(bridgeSize) || !isValidInRange(bridgeSize)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE.message);
        }
    }

    private boolean isNumeric(String bridgeSize) {
        return bridgeSize.chars().allMatch(Character::isDigit);
    }

    private boolean isValidInRange(String bridgeSize) {
        return SIZE_LIMIT_START <= Integer.parseInt(bridgeSize) && Integer.parseInt(bridgeSize) <= SIZE_LIMIT_END;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    private void requestNewBridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
