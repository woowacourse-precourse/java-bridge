package bridge.domain.model;

import bridge.domain.constant.BridgeDirection;

public class Player {

    private String wantToGo;

    public Player() {
        wantToGo = "";
    }

    public void saveDirection(String playerDirectionInput) {
        wantToGo = playerDirectionInput;
    }

    public String notifyDirection() {
        return wantToGo;
    }

    public BridgeDirection getCurrentDirection() {
        return BridgeDirection.findByWordBridgeDirection(wantToGo);
    }

}
