package bridge.domain;

import bridge.type.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private int tryCount = 1;
    
    private List<String> moveHistory = new ArrayList<>();

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getMoveHistory() {
        return Collections.unmodifiableList(moveHistory);
    }

    public void move(String direction) {
        moveHistory.add(direction);
    }

    public void initForRetry() {
        increaseTryCount();
        initMoveHistory();
    }

    private void increaseTryCount() {
        tryCount++;
    }

    private void initMoveHistory() {
        moveHistory.clear();
    }
}
