package model;

import bridge.BridgeDirect;
import bridge.BridgeStatus;

public class UserProgress {


    private final BridgeDirect direct;
    private final BridgeStatus status;

    public UserProgress(BridgeDirect direct, BridgeStatus status) {
        this.direct = direct;
        this.status = status;
    }

    public BridgeDirect getDirect() {
        return direct;
    }

    public BridgeStatus getStatus() {
        return status;
    }
}
