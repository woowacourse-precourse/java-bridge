package bridge;

import controller.Controller;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView(bridgeGame, new ArrayList<>(), new ArrayList<>());
        Controller controller = new Controller(bridgeGame, new InputView(), outputView);
        controller.run();
    }
}
