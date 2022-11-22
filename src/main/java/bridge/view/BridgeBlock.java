package bridge.view;

import bridge.constant.ErrorMessage;
import java.util.Arrays;

public enum BridgeBlock {
    U(1), D(0);

    private final int blockValue;

    BridgeBlock(int blockValue) {
        this.blockValue = blockValue;
    }

    public static BridgeBlock of(int blockValue) {
        return Arrays.stream(BridgeBlock.values())
                .filter(bridgeBlock -> bridgeBlock.blockValue == blockValue)
                .findAny()
                .orElseThrow();
    }

    public static String getBlockName(String move) {
        try {
            BridgeBlock bridgeBlock = BridgeBlock.valueOf(move);
            return bridgeBlock.name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.blockNameError.getErrorMessage());
        }
    }
}
