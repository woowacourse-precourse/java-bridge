package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameStatus;

public class BridgeGame {

    public boolean move(GameStatus gameStatus, Bridge bridge, String s) {
        if (s.equals("U")) {
            if (bridge.getBridge().get(0).equals(s)) {
                gameStatus.topBridge.add("O");
                gameStatus.bottomBridge.add(" ");
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                gameStatus.topBridge.add("X");
                gameStatus.bottomBridge.add(" ");
            }
        }

        if (s.equals("D")) {
            if (bridge.getBridge().get(0).equals(s)) {
                gameStatus.bottomBridge.add("O");
                gameStatus.topBridge.add(" ");
                bridge.getBridge().remove(0);
                return true;
            }
            if (!bridge.getBridge().get(0).equals(s)) {
                gameStatus.bottomBridge.add("X");
                gameStatus.topBridge.add(" ");
            }
        }
        return false;
    }

    public void retry(GameStatus gameStatus) {
        gameStatus.tryCount += 1;
        gameStatus.resetGameStatus();
    }
}
