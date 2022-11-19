package bridge;

import bridge.domain.Bridge;
import bridge.type.FinishCondition;
import bridge.type.PassCondition;


public class BridgeGame {

    private Bridge bridge;
    private GameStatusOperator gameStatusOperator;

    public BridgeGame(Bridge bridge, GameStatusOperator gameStatusOperator) {
        this.bridge = bridge;
        this.gameStatusOperator = gameStatusOperator;
    }

    public static BridgeGame initBridgeGame(Integer bridgeLength) {
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
        gameStatusOperator.toInitialPosition();
        gameStatusOperator.toRestart();
    }

    public void quit() {
        gameStatusOperator.toQuit();
    }

    public FinishCondition checkWhetherFinished() {
        if (bridge.checkWhetherLastBlock(gameStatusOperator.getCurrentPosition())) {
            return FinishCondition.FINISHED;
        }
        return FinishCondition.NOT_FINISHED;
    }

}
