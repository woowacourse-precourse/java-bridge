package bridge.domain;

import bridge.utils.Constants;
import bridge.utils.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {
    private List<String> upBridge;
    private List<String> downBridge;
    private String lastBridge;

    public Bridge() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public void setMovingBridge(String movingInput, String movingResult) {
        if (movingInput.equals(Direction.MOVING_UP.getMovingDirection())) {
            upBridge.add(Constants.MOVING_GAP + movingResult + Constants.MOVING_GAP);
            downBridge.add(Constants.EMPTY_GAP);
            return;
        }
        downBridge.add(Constants.MOVING_GAP + movingResult + Constants.MOVING_GAP);
        upBridge.add(Constants.EMPTY_GAP);
    }

    public void initBridge() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public List<String> getUpBridge() {
        return Collections.unmodifiableList(upBridge);
    }

    public List<String> getDownBridge() {
        return Collections.unmodifiableList(downBridge);
    }

    public String getLastBridge() {
        return lastBridge;
    }

    public void setLastBridge(String lastBridge) {
        this.lastBridge = lastBridge;
    }
}
