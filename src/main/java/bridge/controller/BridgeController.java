package bridge.controller;

import bridge.model.BridgeGame;
import bridge.validator.BridgeMoveInputValidator;
import bridge.validator.BridgeSizeInputValidator;
import bridge.validator.GameRetryValidator;
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
        String bridgeSizeInput = inputView.readBridgeSize();
        BridgeSizeInputValidator.validate(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public Boolean moveBridge() {
        String moving = inputView.readMoving();
        BridgeMoveInputValidator.validate(moving);
        Boolean moveResult = bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getUserMoveState());
        return moveResult;
    }

    public void restart() {
        String command = inputView.readGameCommand();
        GameRetryValidator.validate(command);
        if (bridgeGame.retry(command)) {
            run();
        }
    }

    public void result() {
        outputView.printResult(bridgeGame.getUserMoveState(), bridgeGame.getTryCount(), bridgeGame.isGameOver());
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
