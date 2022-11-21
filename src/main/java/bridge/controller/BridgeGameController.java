package bridge.controller;

import bridge.service.BridgeGame;
import bridge.views.InputView;
import bridge.views.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGameService = new BridgeGame();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void startGame() {
        outputView.printStartMessage();
        requestGenerateBridge();
    }

    private void requestGenerateBridge() {
        try {
            bridgeGameService.generateRandomBridge(requestBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            requestGenerateBridge();
        }
        requestBlock();
    }

    private void requestBlock() {
        checkFinishGame();
        try {
            bridgeGameService.move(inputView.readMoving());
            responseMovingResult();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            requestBlock();
        }
    }

    private void responseMovingResult() {

    }

    private void checkFinishGame() {
    }

    private String requestBridgeSize() {
        return inputView.readBridgeSize();
    }

}
