package bridge.domain.vo;

import bridge.domain.constants.BridgeConstants;
import java.util.ArrayList;
import java.util.List;

public class PlayerMap {

    private List<String> firstLine;
    private List<String> secondLine;

    public PlayerMap() {
        this.firstLine = new ArrayList<>();
        this.secondLine = new ArrayList<>();
    }

    public List<List> getPlayerMap() {
        return (List.of(firstLine, secondLine));
    }

    public int getSize() {
        return firstLine.size();
    }

    public void addResult(Moving moving, boolean value) {
        if (moving.equals(BridgeConstants.BRIDGE_GAME_MOVING_UP)) {
            firstLine.add(getStatus(value));
            secondLine.add(BridgeConstants.BRIDGE_GAME_MOVING_BLANC);
        }
        if (moving.equals(BridgeConstants.BRIDGE_GAME_MOVING_DOWN)) {
            firstLine.add(BridgeConstants.BRIDGE_GAME_MOVING_BLANC);
            secondLine.add(getStatus(value));
        }
    }

    private String getStatus(boolean value) {
        if (value) {
            return BridgeConstants.BRIDGE_GAME_MOVING_SUCCESS;
        }
        return BridgeConstants.BRIDGE_GAME_MOVING_FAIL;
    }
}
