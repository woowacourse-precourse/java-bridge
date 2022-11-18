package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.BridgeSpaceRequestDto;
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

    public void start() {
        outputView.printStart();
        create();
        play();
    }

    private void create() {
        BridgeSizeRequestDto dto = inputView.readBridgeSize();
        bridgeGame.create(dto);
    }

    private void play() {
    }
}
