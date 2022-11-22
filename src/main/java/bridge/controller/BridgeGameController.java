package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame(getBridgeSize());
    private int gameCount;
    private boolean play;

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
        InputView inputView = new InputView();
        String step = inputView.readMoving();
        bridgeGame.move(step);
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
