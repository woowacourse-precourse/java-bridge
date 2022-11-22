package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public void start() {
        inputView.printGameStartMessage();
    }

    public void makeBridge() {
        int bridgeSize = Integer.parseInt(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public Boolean moveBridge() {
        String moving = inputView.readMoving();
        Boolean moveResult = bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getUserMoveState());
        return moveResult;
    }

    public void restart() {
        String command = inputView.readGameCommand();
        if (bridgeGame.retry(command)) {
            run();
        }
    }

    public void result() {
        outputView.printResult(bridgeGame.getUserMoveState(), bridgeGame.getRetryCount(), bridgeGame.isGameOver());
    }

    public void setBridgeGame() {
        start();
        makeBridge();
    }

    public void run() {
        while (moveBridge()) {
        }
        result();
        if (!bridgeGame.isGameOver()) {
            restart();
        }
    }

    public void process() {
        setBridgeGame();
        run();
    }
}
