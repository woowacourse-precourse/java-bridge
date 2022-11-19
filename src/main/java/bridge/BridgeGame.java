package bridge;

import bridge.domain.Bridge;

public class BridgeGame {

    private Bridge bridge;
    private GameStatusOperator gameStatusOperator;

    public BridgeGame(Bridge bridge, GameStatusOperator gameStatusOperator) {
        this.bridge = bridge;
        this.gameStatusOperator = gameStatusOperator;
    }

    public void move() {
        gameStatusOperator.changePosition();
    }

    public void retry() {
        gameStatusOperator.toRestart();
    }

    public void quit() {
        gameStatusOperator.toQuit();
    }
}
