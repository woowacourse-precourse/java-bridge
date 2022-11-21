package bridge;

import bridge.game.BridgeGame;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new OutputView().start();
        BridgeGame game = new BridgeGame();
        boolean gaming = true;
        while (gaming) {
            gaming = game.move();
        }
    }
}
