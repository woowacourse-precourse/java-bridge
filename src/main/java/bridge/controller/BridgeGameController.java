package bridge.controller;

import bridge.constant.GameProcedureStringConstant;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = BridgeGame.getBridgeGame();
    public void start() {
        bridgeGame.createBridge(bridgeLengthInputView());

    }

    private String bridgeLengthInputView() {
        outputView.gameStartMessage();
        return inputView.readBridgeSize();
    }
}
