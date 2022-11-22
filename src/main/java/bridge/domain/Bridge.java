package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {
    private static final String MOVING_GAP = " ";
    private static final String EMPTY_GAP = "   ";
    private List<String> upBridge;
    private List<String> downBridge;
    private String lastBridge;

    public Bridge() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public void setMovingBridge(String movingInput, String movingResult) {
        if (movingInput.equals(Direction.MOVING_UP.getMovingDirection())) {
            upBridge.add(MOVING_GAP + movingResult + MOVING_GAP);
            downBridge.add(EMPTY_GAP);
            return;
        }
        downBridge.add(MOVING_GAP + movingResult + MOVING_GAP);
        upBridge.add(EMPTY_GAP);
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
