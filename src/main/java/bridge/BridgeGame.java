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
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        gameStatusOperator.changePosition();
    }

    public void retry() {
        gameStatusOperator.toRestart();
    }
}
