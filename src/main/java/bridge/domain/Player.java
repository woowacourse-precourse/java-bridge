package bridge.domain;

import bridge.type.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private int tryCount = 1;
    
    private List<String> moveHistory = new ArrayList<>();

    public void move(String direction) {
        moveHistory.add(direction);
    }
    

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getMoveHistory() {
        return Collections.unmodifiableList(moveHistory);
    }



    public boolean isFailToMove() {
        for (int i=0; i<moveHistory.size(); i++) {
            String direction = moveHistory.get(i);
            String answer = bridge.get(i);
            if (!direction.equals(answer)) {
                return true;
            }
        }
        return false;
    }
    public boolean isCompleteToMove() {
        if (moveHistory.size() != bridge.size()) {
            return false;
        }
        if (isFailToMove()) {
            return false;
        }
        return true;
    }

    public void initForRetry() {
        increaseTryCount();
        initMoveHistory();

    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void initMoveHistory() {
        moveHistory.clear();
    }
}
