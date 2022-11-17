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
        outputView.printStart();
        create();
        move();
    }

    private void create() {
        BridgeSizeDto dto = inputView.readBridgeSize();
        bridgeGame.create(dto);
    }

    private void move() {
        String space = inputView.readMoving();
    }
}
