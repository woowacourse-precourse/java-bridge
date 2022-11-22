package bridge.service;

import java.util.List;

public class Move {
    private static final int INIT_NUMBER = 0;
    private static final boolean INIT_RESULT = true;
    private int countNumberOfMove;
    private boolean moveResult;
    private final List<String> bridge;

    public Move(List<String> bridge) {
        this.bridge = bridge;
        init();
    }

    private void init() {
        countNumberOfMove = INIT_NUMBER;
        moveResult = INIT_RESULT;
    }

    public void moveBridge(String moveDirection) {
        moveResult = bridge.get(countNumberOfMove++).equals(moveDirection);
    }

    public boolean getMoveResult(){
        return moveResult;
    }

    public boolean isKeepGoing() {
        if ((bridge.size() == countNumberOfMove) || !moveResult) {
            return false;
        }
        return true;
    }
}
