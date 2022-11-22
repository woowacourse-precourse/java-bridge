package bridge.controller;

import static bridge.constant.message.OutputMessage.FAILURE;

import bridge.GameCommand;
import bridge.Map;
import bridge.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private static int attempts = 1;
    private String success;
    private static GameCommand gameCommand = GameCommand.RETRY;
    private Map map;

    public GameController() {
        outputView = new OutputView();
        success = FAILURE.getMessage();
    }

    public void start() {
        outputView.printStartOfGame();

        proceed();

        outputView.printFinalMessage(success, attempts);
    }

    private void proceed() {

    }
}
