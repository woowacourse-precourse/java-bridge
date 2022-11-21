package bridge.core;

import bridge.domain.Bridge;
import bridge.type.FinishCondition;
import bridge.type.GameStatus;
import bridge.type.PassCondition;
import bridge.type.ProcessCondition;

public class BridgeGame {

    private Bridge bridge;
    private GameStatusOperator gameStatusOperator;

    public BridgeGame(Bridge bridge, GameStatusOperator gameStatusOperator) {
        this.bridge = bridge;
        this.gameStatusOperator = gameStatusOperator;
    }

    public static BridgeGame initBridgeGame(String bridgeLength) {
        GameInitializer gameInitializer = new GameInitializer();
        return gameInitializer.init(bridgeLength);
    }

    public ProcessCondition start() {
        gameStatusOperator.incrementNumberOfTry();
        gameStatusOperator.toOngoing();
        return GameStatus.START;
    }

    public ProcessCondition move(String selectBlock) {
        gameStatusOperator.changePosition();
        Integer currentPosition = gameStatusOperator.getCurrentPosition();
        if (bridge.checkPassableBlock(currentPosition, selectBlock)) {
            return PassCondition.PASS;
        }
        return PassCondition.FAIL;
    }

    public ProcessCondition retry() {
        gameStatusOperator.initPosition();
        gameStatusOperator.toRestart();
        return start();
    }

    public ProcessCondition quit(ProcessCondition finishCondition) {
        gameStatusOperator.toQuit();
        return finishCondition;
    }

    public FinishCondition checkWhetherFinished(ProcessCondition passCondition) {
        if (bridge.checkWhetherLastBlock(gameStatusOperator.getCurrentPosition()) &&
                passCondition == PassCondition.PASS) return FinishCondition.FINISHED;
        return FinishCondition.NOT_FINISHED;
    }

    //== Getter ==//
    public Bridge getBridge() {
        return bridge;
    }

    public GameStatusOperator getGameStatusOperator() {
        return gameStatusOperator;
    }

}
