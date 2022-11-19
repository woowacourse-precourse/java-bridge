package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.utils.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameState gameState;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        gameState = GameState.START;
    }

    public void run() {
        outputView.printStartGame();
        BridgeGame bridgeGame = makeBridgeGame(new BridgeRandomNumberGenerator());
        while (gameState == GameState.START || gameState == GameState.RETRY) {
            move();
        }
    }

    public BridgeGame makeBridgeGame(BridgeNumberGenerator numberGenerator) {
        int bridgeSize;
        try {
            bridgeSize = inputView.readBridgeSize();
            return new BridgeGame(new BridgeMaker(numberGenerator), bridgeSize);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return makeBridgeGame(numberGenerator);
        }
    }

    public void move() {
        try {
            inputView.readMoving();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
