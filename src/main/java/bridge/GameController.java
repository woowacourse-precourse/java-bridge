package bridge;

import static bridge.Validation.*;

public class GameController {
    public GameController() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printStartGame();
        inputView.readBridgeSize();
        isPositiveInteger();
    }
}
