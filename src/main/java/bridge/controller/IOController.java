package bridge.controller;

import bridge.util.InputCallback;
import bridge.util.Message;
import bridge.view.InputView;
import bridge.view.OutputView;

public class IOController {
    private InputView inputView;
    private OutputView outputView;

    public IOController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    private <T> T inputTemplate(InputCallback<T> inputCallback) {
        while (true) {
            try {
                return inputCallback.input();
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

    public Integer inputBridgeSize() {
        return inputTemplate(() -> {
            outputView.printMessage(Message.BRIDGE_SIZE_INPUT_MESSAGE);
            return inputView.readBridgeSize();
        });
    }

    public String inputNextMove() {
        return inputTemplate(() -> {
            outputView.printMessage(Message.MOVE_INPUT_MESSAGE);
            return inputView.readMoving();
        });
    }

    public String inputGameCommand() {
        return inputTemplate(() -> {
            outputView.printMessage(Message.GAME_COMMAND_INPUT_MESSAGE);
            return inputView.readGameCommand();
        });
    }

    public void printMap(String bridgeMap) {
        outputView.printMap(bridgeMap);
    }

    public void printResult(String gameResult) {
        outputView.printMessage(Message.GAME_RESULT_MESSAGE);
        outputView.printResult(gameResult);
    }

    public void printGameStartMessage() {
        outputView.printMessage(Message.GAME_START_MESSAGE);
    }


}
