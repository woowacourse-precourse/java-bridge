package bridge.application;

import bridge.controller.BridgeGameController;
import bridge.controller.request.MoveAtBridgeRequest;
import bridge.domain.bridge.Bridge;
import bridge.handler.InputHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeApplication {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final BridgeGameController bridgeGameController;

    public BridgeApplication() {
        this.inputHandler = new InputHandler(new InputView());
        this.outputView = new OutputView();
        this.bridgeGameController = new BridgeGameController();
    }

    public void run() {
        outputView.startBridgeGame();
        Bridge bridge = inputHandler.getBridgeSize();
        bridgeGameController.moveAtBridge(new MoveAtBridgeRequest(inputHandler, outputView, bridge));
        outputView.printResult(bridgeGameController.getResultBridge(),
                bridgeGameController.getCompleteCrossing(bridge.getSize()),
                bridgeGameController.getTrial()
        );
    }
}
