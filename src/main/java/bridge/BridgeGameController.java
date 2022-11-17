package bridge;

import java.util.List;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
    }

    public void play() {
        setBridgeSize();
        move();
    }

    private void setBridgeSize() {
        try {
            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            bridgeGame.setBridge(bridge);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            setBridgeSize();
        }
    }

    private String selectMove() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return selectMove();
        }
    }

    private void move() {
        String move = selectMove();
        bridgeGame.move(move);
        outputView.printMap(bridgeGame.getCurrentMap());
    }
}
