package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.request.MoveAtBridgeRequest;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeApplication {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameController bridgeGameController;

    public BridgeApplication() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGameController = new BridgeGameController();
    }

    public void run() {
        outputView.startBridgeGame();
        Bridge bridge = inputView.readBridgeSize();
        bridgeGameController.moveAtBridge(new MoveAtBridgeRequest(inputView, outputView, bridge));
        outputView.printResult(bridgeGameController.getResultBridge(),
                bridgeGameController.getCompleteCrossing(bridge.getSize()),
                bridgeGameController.getTrial()
        );
    }
}
