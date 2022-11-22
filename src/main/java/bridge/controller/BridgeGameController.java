package bridge.controller;

import bridge.domain.PlayerMove.PlayerMove;
import bridge.domain.gameManagement.BridgeGame;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    public void run() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();

        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = bridgeGame.constructBridge();

        String movingPosition = PlayerMove.takeMovingPosition();
    }
}
