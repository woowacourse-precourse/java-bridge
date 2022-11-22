package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;

public class BridgeGame {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String WHITE_SPACE = " ";

    public boolean move(GameStatus gameStatus, Bridge bridge, String s) {
        if (s.equals(UP)) {
            if (bridge.getBridge().get(0).equals(s)) {
                gameStatus.topBridge.add(CORRECT);
                gameStatus.bottomBridge.add(WHITE_SPACE);
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                gameStatus.topBridge.add(WRONG);
                gameStatus.bottomBridge.add(WHITE_SPACE);
            }
        }

        if (s.equals(DOWN)) {
            if (bridge.getBridge().get(0).equals(s)) {
                gameStatus.bottomBridge.add(CORRECT);
                gameStatus.topBridge.add(WHITE_SPACE);
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                gameStatus.bottomBridge.add(WRONG);
                gameStatus.topBridge.add(WHITE_SPACE);
            }
        }
        return false;
    }

    public void retry(GameStatus gameStatus) {
        gameStatus.tryCount += 1;
        gameStatus.resetGameStatus();
    }
}
