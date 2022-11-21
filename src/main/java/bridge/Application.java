package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Direction;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.Stack;

public class Application {

    public static void main(String[] args) {
        GameController gameController =
                new GameController(new InputView(), new OutputView(), new BridgeGame());
        gameController.start();
    }
}
