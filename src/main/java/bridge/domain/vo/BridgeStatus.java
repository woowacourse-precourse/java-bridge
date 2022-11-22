package bridge.domain.vo;

import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_DOWN;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_UP;

public enum BridgeStatus {
    U(BRIDGE_GAME_MOVING_UP, 1),
    D(BRIDGE_GAME_MOVING_DOWN, 0);

    private final String movingValue;
    private final int makerValue;

    BridgeStatus(String movingValue, int makerValue) {
        this.movingValue = movingValue;
        this.makerValue = makerValue;
    }

    public static String makerValueToMovingValue(int makerValue) {
        if (BridgeStatus.U.makerValue == makerValue) {
            return U.movingValue;
        }
        return D.movingValue;
    }
}
