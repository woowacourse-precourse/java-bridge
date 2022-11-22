package bridge.controller;

import bridge.domain.gameManagement.BridgeGame;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    public void run() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();

        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = bridgeGame.constructBridge();

        List<String> currentBridge = new ArrayList<>();
        bridgeGame.move(bridge, currentBridge);
    }
}
