package bridge;

import bridge.config.Injector;
import bridge.view.GameView;

public class Application {

    public static void main(String[] args) {
        GameView gameView = Injector.getGameView();

        gameView.doGame();
    }
}
