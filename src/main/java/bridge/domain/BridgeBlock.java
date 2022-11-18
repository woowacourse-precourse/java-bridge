package bridge.domain;

import java.util.Arrays;

public enum BridgeBlock {
    D(0), U(1);

    private final int phase;

    BridgeBlock(int phaseNum) {
        this.phase = phaseNum;
    }

    public static String convertBridgeMessage(int generateNum) {
        return Arrays.stream(BridgeBlock.values())
                .filter(value -> value.phase == generateNum)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new).toString();
    }
}
