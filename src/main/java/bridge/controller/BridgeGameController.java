package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.view.InputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void start() {
        int bridgeSize = inputView.printStartMessage();
        bridgeGameService.makeBridge(bridgeSize);
        String move = inputView.printMoveMessage();
    }
}
