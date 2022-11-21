package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.data.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameSystem {
    private String state = "C";
    private int count = 0;
    private int attempt = 1;

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeMaker make = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final BridgeGame game  = new BridgeGame();

    public void inputBridgeLength() {
        outputView.printWelcome();
        int saveSize = inputView.readBridgeSize();
        game.saveBridge(make.makeBridge(saveSize));
    }

    public void calculate() {

    }

    public void result() {

    }

    private String updatdState() {
        return "C";
    }
}
