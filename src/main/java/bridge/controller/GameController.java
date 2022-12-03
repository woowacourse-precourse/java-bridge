package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            outputView.printStartGame();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }
}
