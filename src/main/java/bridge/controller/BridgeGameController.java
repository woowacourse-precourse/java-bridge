package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.dto.BridgeSizeDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        BridgeSizeDto bridgeSizeDto = inputView.readBridgeSize();
    }
}
