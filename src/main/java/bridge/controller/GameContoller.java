package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.OutputView;

public class GameContoller {
    private final InputController inputController = new InputController();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        outputView.printStart();
        bridgeGame.initBridge(inputController.readBridgeSize());
        do {
            if (move().equals("SUCCESS")) break;
        }while (bridgeGame.retry(inputController.readGameCommand()));
    }

    private String move(){
        while (true){
            String moveState = bridgeGame.move(inputController.readMoving());
            if (moveState.equals("NEXT")) continue;
            return moveState;
        }
    }
}
