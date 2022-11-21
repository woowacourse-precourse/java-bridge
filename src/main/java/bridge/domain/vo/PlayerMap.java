package bridge.domain.vo;

import bridge.domain.constants.BridgeConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerMap {

    private final List<String> firstLine;
    private final List<String> secondLine;

    public PlayerMap() {
        this.firstLine = new ArrayList<>();
        this.secondLine = new ArrayList<>();
    }

    public List<List> getDetail() {
        return Collections.unmodifiableList(List.of(firstLine, secondLine));
    }

    public int getSize() {
        return firstLine.size();
    }

    public void move(Moving moving, boolean value) {
        if (moving.equals(BridgeConstants.BRIDGE_GAME_MOVING_UP)) {
            addMap(getStatus(value), BridgeConstants.BRIDGE_GAME_MOVING_BLANC);
        }
        if (moving.equals(BridgeConstants.BRIDGE_GAME_MOVING_DOWN)) {
            addMap(BridgeConstants.BRIDGE_GAME_MOVING_BLANC, getStatus(value));
        }
    }

    private void addMap(String firstValue, String secondValue) {
        firstLine.add(firstValue);
        secondLine.add(secondValue);
    }

    private String getStatus(boolean value) {
        if (value) {
            return BridgeConstants.BRIDGE_GAME_MOVING_SUCCESS;
        }
        return BridgeConstants.BRIDGE_GAME_MOVING_FAIL;
    }
}
