package bridge;

import View.InputView;
import View.OutputView;

public class Controller {
    private final InputView iView;
    private final OutputView oView;

    private final BridgeGame bridgeGame;

    public Controller(InputView iView, OutputView oView, BridgeGame bridgeGame) {
        this.iView      = iView;
        this.oView      = oView;
        this.bridgeGame = bridgeGame;
    }

    /**
     * input Bridge length and create Bridge
     */
    public void start() {
        oView.printStart();
        int input = iView.readBridgeSize();
    }


}
