package bridge;

import View.InputView;
import View.OutputView;

public class Controller {
    private final InputView iView;
    private final OutputView oView;

    private BridgeGame bridgeGame;

    public Controller(InputView iView, OutputView oView) {
        this.iView = iView;
        this.oView = oView;
    }

    /**
     * input Bridge length and create Bridge
     */
    public void start() {
        oView.printStart();
        int input = iView.readBridgeSize();
        BridgeRandomNumberGenerator rng = new BridgeRandomNumberGenerator();
        this.bridgeGame = new BridgeGame(new BridgeMaker(rng).makeBridge(input));
    }

    /**
     * input user command, move user
     */
    public void move() {
        while (true) {
            String command = iView.readMoving();
            break;
        }
    }


}
