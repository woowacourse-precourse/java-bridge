package bridge.controller;

import bridge.constant.AfterMovingStatusConstant;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = BridgeGame.getBridgeGame();
    public void start() {
        final List<String> bridge = bridgeGame.createBridge(bridgeLengthInputView());
        Bridge randomCreateBridge = new Bridge(bridge);
        while (true) {
            Bridge thisTurnBridge = new Bridge();
            while (true) {
                AfterMovingStatusConstant afterMovingStatusConstant = movingProcedure(randomCreateBridge,
                        thisTurnBridge);
                String bridgeStatus = thisTurnBridge.toString(randomCreateBridge);
            }
        }

    }

    private AfterMovingStatusConstant movingProcedure(Bridge randomCreateBridge, Bridge thisTurnBridge) {
        return bridgeGame.move(randomCreateBridge, thisTurnBridge,
                thisTurnMoveBridgeInputView());
    }

    private String thisTurnMoveBridgeInputView() {
        outputView.printChooseWhereToGoBridgeMessage();
        return inputView.readMoving();
    }

    private String bridgeLengthInputView() {
        outputView.gameStartMessage();
        return inputView.readBridgeSize();
    }
}
