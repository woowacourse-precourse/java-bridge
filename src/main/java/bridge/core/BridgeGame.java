package bridge.core;

import bridge.core.exception.CommonException;
import bridge.core.exception.Error;
import bridge.core.exception.ExceptionHandler;
import bridge.core.exception.InvalidInputException;
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
        try {
            GameInitializer gameInitializer = new GameInitializer();
            return gameInitializer.init(bridgeLength);
        } catch (InvalidInputException e) {
            ExceptionHandler.handle(e);
            return null;
        } catch (Exception e) {
            throw new CommonException(Error.FAIL, "게임 초기화");
        }
    }

    public ProcessCondition start() {
        gameStatusOperator.incrementNumberOfTry();
        gameStatusOperator.toOngoing();
        return GameStatus.START;
    }

    public ProcessCondition move(String selectBlock) {
        try {
            gameStatusOperator.changePosition();
            Integer currentPosition = gameStatusOperator.getCurrentPosition();
            if (bridge.checkPassableBlock(currentPosition, selectBlock)) return PassCondition.PASS;
            return PassCondition.FAIL;
        } catch (InvalidInputException e) {
            gameStatusOperator.turnBackPosition();
            ExceptionHandler.handle(e);
            return null;
        } catch (Exception e) {
            throw new CommonException(Error.FAIL, "플레이어 이동");
        }
    }

    public ProcessCondition selectRetryOrQuit(String gameCommand) {
        return GameStatus.getGameStatusByGameCommand(gameCommand);
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
