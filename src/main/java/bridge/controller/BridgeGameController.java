package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.constant.BridgeConstant;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

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
            this.output.printMap(this.bridge.getBridge(), this.bridgeGame.getMap());
            checkBridgeGameStatus();
        }
        this.output.printResult(this.bridge.getBridge(), this.bridgeGame.getMap(), this.bridgeGame);
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
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
        this.bridge = new Bridge(bridge);
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
