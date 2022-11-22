package bridge.domain.model;

import bridge.domain.constant.BridgeDirection;

public class Player {

    public BridgeDirection getCurrentDirection(String playerWantToGo) {
        return BridgeDirection.findByWordBridgeDirection(playerWantToGo);
    }
}
