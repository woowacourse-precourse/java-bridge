package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.view.OutputView;

public class GameController {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final Player player = new Player();

    public GameController() {
        outputView.printStart();
        bridgeGame.initBridgeGame(inputController.readBridgeSize(), player);
    }

    public void run() {
        do {
            if (move().equals("SUCCESS")) break;
        } while (bridgeGame.retry(inputController.readGameCommand()));

        outputView.printResult(player);
    }

    private String move() {
        while (true) {
            String moveState = bridgeGame.move(inputController.readMoving());
            outputView.printMap(player);
            if (moveState.equals("NEXT")) continue;
            return moveState;
        }
    }
}
