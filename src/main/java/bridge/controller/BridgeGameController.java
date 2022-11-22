package bridge.controller;

import bridge.domain.gameManagement.BridgeGame;
import bridge.domain.gameOver.GameResult;
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
        int gameAttemptsCount = bridgeGame.move(bridge, currentBridge);
        GameResult.takeResult(currentBridge, bridge, gameAttemptsCount);
    }
}
