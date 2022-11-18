package bridge.domain;

import java.util.Arrays;

public enum BridgePhase {
    D(0), U(1);

    private final int phase;

    BridgePhase(int phaseNum) {
        this.phase = phaseNum;
    }

    public static String convertBridgeMessage(int generateNum) {
        return Arrays.stream(BridgePhase.values())
                .filter(value -> value.phase == generateNum)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new).toString();
    }
}
