package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getBridgeSize() {
        outputView.printGameStart();
        outputView.printEnterSize();
        return inputView.readBridgeSize();
    }

    public String getMovingDirection() {
        outputView.printInputMoving();
        return inputView.readMoving();
    }

    public String getGameCommand() {
        outputView.printInputGameCommand();
        return inputView.readGameCommand();
    }
}
