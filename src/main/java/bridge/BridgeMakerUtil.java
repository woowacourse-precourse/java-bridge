package bridge;

import bridge.controller.BridgeStatus;

public class BridgeMakerUtil {
    public String parseZeroOrOneToUorD(int number) {
        String movement = "";
        for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
            if (number == bridgeStatus.getNumber()) {
                movement = bridgeStatus.getMoving();
            }
        }
        return movement;
    }
}
