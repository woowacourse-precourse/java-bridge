package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameCommand;
import bridge.model.Moving;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController(BridgeMaker bridgeMaker) {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        this.bridgeMaker = bridgeMaker;
    }

    public void run() {
        outputView.printInit();
        Bridge bridge = makeBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        play(bridgeGame);
    }

    private Bridge makeBridge() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            return bridgeMaker.constructBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makeBridge();
        }
    }

    private void play(BridgeGame bridgeGame) {
        bridgeGame.startGame();
        while (bridgeGame.isPlayable()) {
            move(bridgeGame);
            checkRetry(bridgeGame);
        }
        outputView.printResult(bridgeGame.getPlayer(), bridgeGame);
    }

    private void move(BridgeGame bridgeGame) {
        while (bridgeGame.isPlayable()) {
            moveOneStep(bridgeGame);
            outputView.printMap(bridgeGame.getPlayer());
        }
    }

    private void moveOneStep(BridgeGame bridgeGame) {
        try {
            String moving = inputView.readMoving();
            bridgeGame.move(Moving.toMoving(moving));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            moveOneStep(bridgeGame);
        }
    }

    private void checkRetry(BridgeGame bridgeGame) {
        if (bridgeGame.isPlayerDead()) {
            readGameCommand(bridgeGame);
        }
    }

    private void readGameCommand(BridgeGame bridgeGame) {
        try {
            GameCommand gameCommand = GameCommand.toGameCommand(inputView.readGameCommand());
            checkRetryCommand(gameCommand, bridgeGame);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            readGameCommand(bridgeGame);
        }
    }

    private void checkRetryCommand(GameCommand gameCommand, BridgeGame bridgeGame) {
        if (gameCommand.equals(GameCommand.R)) {
            bridgeGame.retry();
        }
    }
}
