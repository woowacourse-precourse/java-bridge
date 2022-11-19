package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(),
                                                           new OutputView(),
                                                           new BridgeRandomNumberGenerator());
        gameController.execute();
    }
}
