package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        try {
            int bridgeSize = inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
