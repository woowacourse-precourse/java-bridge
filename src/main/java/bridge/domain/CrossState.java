package bridge.domain;

import java.util.Arrays;

public enum CrossState {
    SUCCESS("O", true, true),
    FAILED("X", true, false),
    NONE(" ", false, false);

    private final String status;
    private final boolean isSameBridgeMovement;
    private final boolean isCrossable;

    CrossState(String status, boolean isSameBridgeMovement, boolean isCrossable) {
        this.status = status;
        this.isSameBridgeMovement = isSameBridgeMovement;
        this.isCrossable = isCrossable;
    }

    public String getStatus() {
        return status;
    }

    public static CrossState findByStatus(boolean isSameBridgeMovement, boolean isCrossable) {
        return Arrays.stream(values())
                .filter(value -> value.isSameBridgeMovement == isSameBridgeMovement)
                .filter(value -> value.isCrossable == isCrossable)
                .findAny()
                .orElse(NONE);
    }
}
