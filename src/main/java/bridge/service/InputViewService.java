package bridge.service;


import bridge.view.InputView;
import bridge.view.OutputView;

public class InputViewService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int inputBridgeSize() {
        try {
            outputView.printChoiceBridgeSize();
            int bridgeSize = inputView.readBridgeSize();
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return inputBridgeSize();
    }

    public String inputMoving() {
        try {
            outputView.printChoiceUpOrDown();
            String move = inputView.readMoving();
            return move;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return inputMoving();
    }

    public String inputGameCommand() {
        try {
            outputView.printChoiceRetry();
            String gameCommand = inputView.readGameCommand();
            return gameCommand;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return inputGameCommand();
    }
}
