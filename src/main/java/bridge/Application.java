package bridge;

import bridge.Controller.GameController;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Application {
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static OutputView outputView = new OutputView();
    static GameController gameController = new GameController(inputView,bridgeGame,bridgeMaker,outputView);

    public static void main(String[] args) {
        try {
            GAMESTART();
            GAMEPROCESS();
            GAMESTOP();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void GAMESTART() {
        gameController.GAMESTART();
    }

    public static void GAMESTOP() {
        gameController.STOPGAME();
    }

    public static void GAMEPROCESS() {
        do {
            gameController.RUNPROCESS();
            if (bridgeGame.isSuccecss()) {
                break;
            }
        } while (gameController.SELECTRESTART());
    }
}
