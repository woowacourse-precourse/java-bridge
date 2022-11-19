package bridge.controller;

import bridge.constants.InputMessage;
import bridge.view.InputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final InputMessage inputMessage = new InputMessage();
    public void startGame() {
        inputView.printMessage(inputMessage.START_GAME);
    }
}
