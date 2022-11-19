package bridge;

import bridge.domain.Bridge;
import bridge.type.PassCondition;

public class BridgeGame {

    private Bridge bridge;
    private GameStatusOperator gameStatusOperator;

    public BridgeGame(Bridge bridge, GameStatusOperator gameStatusOperator) {
        this.bridge = bridge;
        this.gameStatusOperator = gameStatusOperator;
    }

    public PassCondition move(String selectBlock) {
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        if (bridge.checkPassableBlock(currentPosition, selectBlock)) {
            gameStatusOperator.changePosition();
            return PassCondition.PASS;
        }
        return PassCondition.FAIL;
    }

    public void retry() {
        gameStatusOperator.toRestart();
    }

    public void quit() {
        gameStatusOperator.toQuit();
    }
}
