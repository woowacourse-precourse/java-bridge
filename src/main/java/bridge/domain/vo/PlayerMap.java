package bridge.domain.vo;

import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_BLANC;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_DOWN;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_FAIL;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_SUCCESS;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_UP;

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
        if (moving.equals(BRIDGE_GAME_MOVING_UP)) {
            addMap(getStatus(value), BRIDGE_GAME_MOVING_BLANC);
        }
        if (moving.equals(BRIDGE_GAME_MOVING_DOWN)) {
            addMap(BRIDGE_GAME_MOVING_BLANC, getStatus(value));
        }
    }

    private void addMap(String firstValue, String secondValue) {
        firstLine.add(firstValue);
        secondLine.add(secondValue);
    }

    private String getStatus(boolean value) {
        if (value) {
            return BRIDGE_GAME_MOVING_SUCCESS;
        }
        return BRIDGE_GAME_MOVING_FAIL;
    }
}
