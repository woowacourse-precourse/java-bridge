package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.model.Retry.isRetry;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private BridgeMaker bridgeMaker;
    private final int WIDTH = 2;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public boolean gamePlay() {
        OutputView.printStart();

        bridgeGame.setBridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));

        while (!bridgeGame.isEnd() && !bridgeGame.isRetire()) gameProcess();

        gameFinalBridgeState();
        return bridgeGame.isAnswer();
    }

    public void gameProcess() {
        do {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame.getInput(), WIDTH);

            if (bridgeGame.isAnswer()) break;
        } while (gameRetry());
    }

    public boolean gameRetry() {
        if (!isRetry(InputView.readGameCommand())) {
            bridgeGame.setRetire(true);
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    public void gameFinalBridgeState() {
        OutputView.printFinal();
        OutputView.printMap(bridgeGame.getInput(), WIDTH);
    }

    public void gameResult() {
        OutputView.printResult(gamePlay(), bridgeGame.getRetry());
    }
}
