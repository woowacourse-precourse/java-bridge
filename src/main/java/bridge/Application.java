package bridge;

import bridge.controller.GameController;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        Result result = new Result();
        GameController gameController = new GameController(bridgeGame, result);

        OutputView.printStart();
        gameController.setEternalThing();
        gameController.playGame();
    }
}
