package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        createBridgeGame();
        do {
            playTurn();
        } while (this.bridgeGame.isOnWay());
        announceFinalResult();
    }

    private void createBridgeGame() {
        int inputSize = this.inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

    private void playTurn() {
        String bridgePicture = this.bridgeGame.move();
        this.outputView.printMap(bridgePicture);
        if (this.bridgeGame.isFail()) {
            retryTurn();
        }
    }

    private void
}
