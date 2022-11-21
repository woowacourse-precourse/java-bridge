package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final boolean CORRECT_BRIDGE = true;
    private static final boolean WRONG_BRIDGE = false;
    private static final boolean GAME_END = true;
    private static final boolean GAME_ING = false;
    private static final int INIT_TRY_COUNT = 1;

    private List<Boolean> movingResult = new LinkedList<>();

    private int tryCount = INIT_TRY_COUNT;
    private boolean gameStatus = GAME_ING;

    public boolean move(List<String> bridge, String moving) {
        if (moving.equals(bridge.get(movingResult.size()))) {
            movingResult.add(CORRECT_BRIDGE);
            return CORRECT_BRIDGE;
        }

        movingResult.add(WRONG_BRIDGE);
        return WRONG_BRIDGE;
    }

    public List<Boolean> getMovingResult() {
        return movingResult;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void retry() {
        tryCount++;
        movingResult = new LinkedList<>();
    }

    public void end() {
        gameStatus = GAME_END;
    }

    public boolean isEnd(List<String> bridge) {
        if (bridge.size() == movingResult.size() && getMovingResult().get(getMovingResult().size() - 1)) {
            return GAME_END;
        }
        return gameStatus;
    }
}
