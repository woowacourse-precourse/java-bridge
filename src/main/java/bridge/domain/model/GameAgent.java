package bridge.domain.model;

import bridge.domain.constant.BridgeDirection;

import java.util.ArrayList;
import java.util.List;

public class GameAgent {


    private List<String> bridge;

    public GameAgent() {

        this.bridge = new ArrayList<>();
    }

    public void initialize(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean checkPossibleToCross(String playerWantedToGo, int trial) {
        String bridgeDirection = bridge.get(trial);
        return bridgeDirection.equals(playerWantedToGo);
    }

}
