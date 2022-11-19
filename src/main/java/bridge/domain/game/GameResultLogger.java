package bridge.domain.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResultLogger {
    private final List<CrossResult> topRoad;
    private final List<CrossResult> downRoad;
    private int numOfAttempts;

    public GameResultLogger() {
        this.numOfAttempts = 1;
        this.topRoad = new ArrayList<>();
        this.downRoad = new ArrayList<>();
    }

    public void reset() {
        this.topRoad.clear();
        this.downRoad.clear();
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
        return direction.equals(BridgeGame.UP_DIRECTION);
    }

    public int getNumOfAttempts() {
        return numOfAttempts;
    }

    public List<CrossResult> getTopRoad() {
        return Collections.unmodifiableList(topRoad);
    }

    public List<CrossResult> getDownRoad() {
        return Collections.unmodifiableList(downRoad);
    }
}
