package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame(getBridgeSize());
    int gameCount;
    boolean play;

    public BridgeGameController() {
        this.gameCount = 1;
        this.play = true;
    }

    public void start() {
        while (play) {
            play = judgePlayerMove();
            showBridge();
            if (!isGameLife()) {
                play = askRetry();
            }
        }
        showResult();
    }

    private boolean judgePlayerMove() {
        bridgeGame.move();
        return !bridgeGame.isEnd();
    }

    private void showBridge() {
        outputView.printMap(bridgeGame.getGameMap());
    }

    private boolean isGameLife() {
        return bridgeGame.getStatus().isLife();
    }

    private int getBridgeSize() {
        outputView.printStartMessage();
        return inputView.readBridgeSize();
    }

    private boolean askRetry() {
        String status = inputView.readGameCommand();

        if (status.equals(Command.RETRY.getCommand())) {
            bridgeGame.retry();
            gameCount++;
            return true;
        }
        return false;
    }

    private void showResult() {
        outputView.printResult(bridgeGame.getGameMap(), bridgeGame.getStatus(), gameCount);
    }
}
