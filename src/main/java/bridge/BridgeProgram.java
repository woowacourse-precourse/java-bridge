package bridge;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeProgram {

    private BridgeGame bridgeGame;

    private InputView inputView;

    private OutputView outputView;

    public BridgeProgram() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        printStartGame();
    }

    public void printStartGame() {
        outputView.printStart();
    }
}
