package bridge.Controller;

import bridge.Model.Bridge;
import bridge.View.InputView;

public class GameController {
    public void run(Bridge bridge) {

    }

    public void handleInput() {
        InputView inputView = new InputView();

        String input = inputView.readMoving();
    }
}
