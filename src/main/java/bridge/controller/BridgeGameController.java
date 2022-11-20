package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.views.InputView;
import bridge.views.OutputView;

public class BridgeGameController {
    private final BridgeGameService bridgeGameService = new BridgeGameService();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void startGame() {
        outputView.printStartMessage();
        try {
            bridgeGameService.generateRandomBridge(Integer.parseInt(inputView.readBridgeSize()));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
