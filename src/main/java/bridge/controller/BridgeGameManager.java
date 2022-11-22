package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.Command;
import bridge.model.Direction;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameManager {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void play() {
        outputView.printStartMessage();
        makeBridge();
        crossBridge();
        outputView.printResult(bridgeGame);
    }

    private void makeBridge() {
        try {
            int readBridgeSize = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(readBridgeSize);
            bridgeGame = new BridgeGame(bridge);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            makeBridge();
        }
    }

    private void crossBridge() {
        while (!bridgeGame.isCrossed()) {
            bridgeGame.move(chooseDirection());
            outputView.printRoute(bridgeGame);
            if (bridgeGame.isFailed()) {
                if (inputGameCommand() == Command.RETRY) {
                    bridgeGame.retry();
                    continue;
                }
                return;
            }
        }
    }

    private Direction chooseDirection() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);

            return chooseDirection();
        }
    }

    private Command inputGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return inputGameCommand();
        }
    }
}