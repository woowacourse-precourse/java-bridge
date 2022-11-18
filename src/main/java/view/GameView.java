package view;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class GameView {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void init() {
        outputView.printStartMessage();
        bridgeMaker.makeBridge(inputView.readBridgeSize());
        game();
    }

    public void game() {
        inputView.readMoving();
    }
}
