package bridge;

import bridge.Controller.GameController;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;

public class Application {
    static BridgeGame bridgeGame = new BridgeGame();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static GameController gameController = new GameController(bridgeGame,bridgeMaker);

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
