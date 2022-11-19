package bridge;

import bridge.domain.Bridge;
import bridge.type.GameStatus;
import bridge.type.PassCondition;

import java.util.List;

public class BridgeGame {

    private Bridge bridge;
    private GameStatusOperator gameStatusOperator;

    public BridgeGame(Bridge bridge, GameStatusOperator gameStatusOperator) {
        this.bridge = bridge;
        this.gameStatusOperator = gameStatusOperator;
    }

    public BridgeGame initBridgeGame(Integer bridgeLength) {
        Bridge bridge = new Bridge(BridgeMaker.getBridgeMaker().makeBridge(bridgeLength));
        GameStatusOperator gameStatusOperator = GameStatusOperator.initGameStatusOperator();
        return new BridgeGame(bridge, gameStatusOperator);
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
