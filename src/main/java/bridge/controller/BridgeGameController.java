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
    private static int gameCount = 0;
    public void start() {
        final List<String> bridge = bridgeGame.createBridge(bridgeLengthInputView());
        Bridge randomCreateBridge = new Bridge(bridge);
        while (true) {
            Bridge thisTurnBridge = createThisTurnBridge();
            while (true) {
                AfterMovingStatusConstant afterMovingStatusConstant = movingBridgeWithReturnStatusWithView(randomCreateBridge,
                        thisTurnBridge);
            }
        }

    }

    private static Bridge createThisTurnBridge() {
        gameCount += 1;
        return new Bridge();
    }

    private AfterMovingStatusConstant movingBridgeWithReturnStatusWithView(Bridge randomCreateBridge, Bridge thisTurnBridge) {
        AfterMovingStatusConstant afterMovingStatusConstant = movingProcedure(randomCreateBridge,
                thisTurnBridge);
        outputView.printMap(thisTurnBridge.toString(randomCreateBridge));
        return afterMovingStatusConstant;
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
