package bridge;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
