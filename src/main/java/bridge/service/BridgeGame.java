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
        return inputIsUp(gameStatus, bridge, s) || inputIsDown(gameStatus, bridge, s);
    }

    public void retry(GameStatus gameStatus) {
        gameStatus.tryCount += 1;
        gameStatus.resetGameStatus();
    }

    private boolean inputIsUp(GameStatus gameStatus, Bridge bridge, String s) {
        if (s.equals(UP)) {
            if (upAndCorrect(gameStatus, bridge, s)) {
                return true;
            }
            upAndWrong(gameStatus, bridge, s);
        }
        return false;
    }

    private boolean upAndCorrect(GameStatus gameStatus, Bridge bridge, String s) {
        if (bridge.checkTheBridge(s)) {
            gameStatus.topBridge.add(CORRECT);
            gameStatus.bottomBridge.add(WHITE_SPACE);
            bridge.passToTheNextSpace();
            return true;
        }
        return false;
    }

    private void upAndWrong(GameStatus gameStatus, Bridge bridge, String s) {
        if (!bridge.checkTheBridge(s)) {
            gameStatus.topBridge.add(WRONG);
            gameStatus.bottomBridge.add(WHITE_SPACE);
        }
    }

    private boolean inputIsDown(GameStatus gameStatus, Bridge bridge, String s) {
        if (s.equals(DOWN)) {
            if (downAndCorrect(gameStatus, bridge, s)) {
                return true;
            }
            downAndWrong(gameStatus, bridge, s);
        }
        return false;
    }

    private boolean downAndCorrect(GameStatus gameStatus, Bridge bridge, String s) {
        if (bridge.checkTheBridge(s)) {
            gameStatus.bottomBridge.add(CORRECT);
            gameStatus.topBridge.add(WHITE_SPACE);
            bridge.passToTheNextSpace();
            return true;
        }
        return false;
    }

    private void downAndWrong(GameStatus gameStatus, Bridge bridge, String s) {
        if (!bridge.checkTheBridge(s)) {
            gameStatus.bottomBridge.add(WRONG);
            gameStatus.topBridge.add(WHITE_SPACE);
        }
    }
}