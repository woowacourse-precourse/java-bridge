package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeResult;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    public BridgeGameController() {
        playBridgeGame();
    }


    private void playBridgeGame() {
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = InputController.inputBridgeSize();
        List<BridgeResult> bridgeResults = new ArrayList<>();
        bridgeGame.move(bridgeResults, bridge);
        OutputView.printMap(bridgeResults);
    }

}
