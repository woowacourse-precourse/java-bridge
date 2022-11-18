package bridge;

import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame(new InputView(), new OutputView());
        game.start();
    }
}
