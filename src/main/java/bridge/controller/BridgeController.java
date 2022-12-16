package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Result;
import bridge.util.BridgeGameStatus;
import bridge.util.OutputPharses;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;
    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView  = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void initBridgeController() {
        outputView.printInfo(OutputPharses.START_MSG.getMsg());
    }

    public void startGame() {
        int bridgeSize = getBridgeSize();
        bridgeGame.setBridge(bridgeSize);
        bridgeGame.setResult(startEachGame());
        gameEnd();
    }

    public boolean startEachGame() {
        while (!eachgame()) {
            String retryCommand = getRetry();
            if (isExit(retryCommand)) {
                return false;
            }
            bridgeGame.retry();
        }
        return true;
    }

    public boolean eachgame() {
        bridgeGame.startGame();

        while(move()) {
            if (isFinish()) {
                return true;
            }
        }

        return false;
    }

    public boolean move() {
        boolean moveResult = bridgeGame.move(getMove());
        printMap();
        return moveResult;
    }



    public boolean isExit(String retryCommand) {
        return retryCommand.equals(BridgeGameStatus.QUIT.getGameStatus());
    }

    public boolean isFinish() {
        return bridgeGame.isFinish();
    }

    public void gameEnd() {
        Result result = bridgeGame.getResult();
        outputView.printEmptyLn();
        outputView.printInfo(OutputPharses.GAME_RESULT_MSG.getMsg());
        printMap();
        outputView.printResult(result.getResult(), result.getPlayCount());
    }

    public void printMap() {
        outputView.printMap(bridgeGame.getPlayer());
    }

    public int getBridgeSize() {
        while (true) {
            try {
                outputView.printEmptyLn();
                outputView.printInfo(OutputPharses.BRIDGE_LENGTH_MSG.getMsg());
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                outputView.printInfo(exception.getMessage());
            }
        }
    }

    public String getMove() {
        while (true) {
            try {
                outputView.printEmptyLn();
                outputView.printInfo(OutputPharses.MOVE_MSG.getMsg());
                return inputView.readMoving();
            } catch (IllegalArgumentException exception) {
                outputView.printInfo(exception.getMessage());
            }
        }
    }

    public String getRetry() {
        while (true) {
            try {
                outputView.printEmptyLn();
                outputView.printInfo(OutputPharses.RESTART_MSG.getMsg());
                return inputView.readGameCommand();
            } catch (IllegalArgumentException exception) {
                outputView.printInfo(exception.getMessage());
            }
        }
    }
}
