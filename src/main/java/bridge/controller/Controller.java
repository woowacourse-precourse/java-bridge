package bridge.controller;

import bridge.dto.Bridge;
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

        Bridge bridge = generateBridge();
    }

    private Bridge generateBridge() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            return bridgeGame.generateBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateBridge();
        }
    }

}