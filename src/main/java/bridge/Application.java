package bridge;

import bridge.Controller.GameController;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(inputView,bridgeGame,bridgeMaker,outputView);
        try {
            gameController.GAMESTART();
            do {
                gameController.RUNPROCESS();
                if (bridgeGame.isSuccecss()) {
                    break;
                }
            } while (gameController.SELECTRESTART());
            gameController.STOPGAME();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
