package bridge;

import bridge.controller.GameController;
import bridge.view.OutputView;

public class Application {
    private static boolean gameContinue;

    public static void main(String[] args) {
        OutputView.printGameStartMsg();
        try {
            createGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createGame();
        }
    }

    static void createGame() {
        GameController gameController = new GameController();
        do {
            gameContinue = gameController.run();
        } while (gameContinue);

    }
}
