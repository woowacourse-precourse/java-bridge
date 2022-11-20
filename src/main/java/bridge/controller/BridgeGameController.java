package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.view.InputView;

public class BridgeGameController {

    private static int totalTries = 0;
    private static int currentPosition = -1;

    private final InputView inputView = new InputView();
    private final BridgeGameService bridgeGameService = new BridgeGameService();

    public void start() {
        int bridgeSize = inputView.printStartMessage();
        bridgeGameService.makeBridge(bridgeSize);

        currentPosition++;
        String move = inputView.printMoveMessage();
        boolean success = bridgeGameService.moveAndReturnSuccess(currentPosition, move);
    }
}
