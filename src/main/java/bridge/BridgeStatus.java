package bridge;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum BridgeStatus {
    U(1), D(0);

    private final int safeValue;

    BridgeStatus(int safeValue) {
        this.safeValue = safeValue;
    }

    public static BridgeStatus of(int safeValue) {
        return Arrays.stream(BridgeStatus.values())
                .filter(bridgeStatus -> bridgeStatus.safeValue == safeValue)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 다리 무작위 값은 0 또는 1이어야 합니다"));
    }
}
