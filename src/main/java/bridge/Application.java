package bridge;

import bridge.game.GameManager;
import bridge.view.ErrorView;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        try {
            gameManager.game();
        } catch (RuntimeException exception) {
            ErrorView.printErrorMessage(exception);
        }
    }
}
