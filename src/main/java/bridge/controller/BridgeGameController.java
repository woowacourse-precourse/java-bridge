package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Command;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame(makeGameBridge());
    int gameCount;
    boolean play;

    public BridgeGameController() {
        this.gameCount = 1;
        this.play = true;
    }

    public void start() {
        while (play) {
            playerMove();
            showBridge();
            if (isGameEnd()) {
                askRetry();
            }
        }
        showResult();
    }

    private void playerMove() {
        bridgeGame.move();
        play = !bridgeGame.isEnd();
    }

    private void showBridge() {
        outputView.printMap(bridgeGame.getGameMap());
    }

    private boolean isGameEnd() {
        return !bridgeGame.getStatus().isLife();
    }

    private Bridge makeGameBridge() {
        outputView.printStartMessage();

        int bridgeSize = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void askRetry() {
        String status = inputView.readGameCommand();

        if (status.equals(Command.RETRY.getCommand())) {
            bridgeGame.retry();
            gameCount++;
            return;
        }
        play = false;
    }

    private void showResult() {
        outputView.printResult(bridgeGame.getGameMap(), bridgeGame.getStatus(), gameCount);
    }
}
