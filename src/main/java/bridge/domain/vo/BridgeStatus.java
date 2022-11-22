package bridge.domain.vo;

import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MAKER_DOWN;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MAKER_UP;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_DOWN;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_UP;

public enum BridgeStatus {
    U(BRIDGE_GAME_MOVING_UP, BRIDGE_GAME_MAKER_UP),
    D(BRIDGE_GAME_MOVING_DOWN, BRIDGE_GAME_MAKER_DOWN);

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
