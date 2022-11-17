package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {
    private static final String UP_DIRECTION = "U";

    private List<CrossResult> topRoad;
    private List<CrossResult> downRoad;
    private int numOfAttempts;

    public BridgeGameResult() {
        this.numOfAttempts = 1;
        this.topRoad = new ArrayList<>();
        this.downRoad = new ArrayList<>();
    }

    public void reset() {
        this.topRoad = new ArrayList<>();
        this.downRoad = new ArrayList<>();
        this.numOfAttempts++;
    }

    public void logResult(String direction, CrossResult result) {
        if (isUpside(direction)) {
            topRoad.add(result);
            downRoad.add(CrossResult.PASS);
            return ;
        }
        topRoad.add(CrossResult.PASS);
        downRoad.add(result);
    }

    private boolean isUpside(String direction) {
        return direction.equals(UP_DIRECTION);
    }

    public int getNumOfAttempts() {
        return numOfAttempts;
    }

    public List<CrossResult> getTopRoad() {
        return topRoad;
    }

    public List<CrossResult> getDownRoad() {
        return downRoad;
    }
}
