package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.view.OutputView;
import bridge.constant.MoveState;

import java.util.List;

public class GameController {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final Player player = new Player();

    public GameController() {
        outputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputController.readBridgeSize());
        bridgeGame.initBridgeGame(player, bridge);
    }

    public void run() {
        do {
            if (move().equals(MoveState.SUCCESS_TEXT)) break;
        } while (bridgeGame.retry(inputController.readGameCommand()));

        outputView.printResult(player);
    }

    private String move() {
        while (true) {
            String moveState = bridgeGame.move(inputController.readMoving());
            outputView.printMap(player);
            if (moveState.equals(MoveState.NEXT_TEXT)) continue;
            return moveState;
        }
    }
}
