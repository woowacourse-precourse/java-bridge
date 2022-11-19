package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        outputView.printGameStart();

        generateBridge();
    }

    private void generateBridge() {
        int bridgeSize = 0;

        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateBridge();
        }
    }

}