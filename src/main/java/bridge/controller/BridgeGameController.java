package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeConstant;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private InputView input;
    private OutputView output;
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private boolean complete;

    public BridgeGameController() {
        initFields();
    }

    public void gameStart() {
        while (!this.complete) {
            move();
            // TODO: 2022/11/20 printMap 구현 후 추가
            checkBridgeGameStatus();
        }
        // TODO: 2022/11/20 printResult 구현 후 추가
    }

    private void move() {
        this.output.printInputBridgeSpace();
        String moving = this.input.readMoving();
        this.bridgeGame.move(moving);
    }

    private void selectRetry() {
        this.output.printInputGameRetry();
        String gameCommand = this.input.readGameCommand();
        if (gameCommand.equals(BridgeConstant.RESTART)) {
            this.bridgeGame.retry();
        }
        if (gameCommand.equals(BridgeConstant.QUIT)) {
            this.complete = true;
        }
    }

    private void checkBridgeGameStatus() {
        if (this.bridgeGame.isSuccess()) {
            this.complete = true;
        }
        if (this.bridgeGame.isNeedsRetry()) {
            selectRetry();
        }
    }

    private void initBridge() {
        this.output.printInputBridgeSize();
        int size = this.input.readBridgeSize();
        this.bridge = new Bridge(size);
    }

    private void initFields() {
        this.input = new InputView();
        this.output = new OutputView();
        this.output.printGameStart();
        initBridge();
        this.bridgeGame = new BridgeGame(this.bridge.getBridge());
        this.complete = false;
    }
}
