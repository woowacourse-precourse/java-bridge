package bridge.controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeGameResult;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final BridgeGameResult gameResult;

    private boolean play;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        gameResult = new BridgeGameResult();
        play = true;
    }

    public void play() {
        start();
        Bridge bridge = makeBridge(makeBridgeSize());
    }

    private void start() {
        outputView.printGameStartMsg();
    }

    private Bridge makeBridge(int size) {
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private int makeBridgeSize() {
        outputView.printBridgeSizeMsg();
        return inputView.readBridgeSize();
    }
}
