package bridge;

public class GameController {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    private int inputBridgeSize() {
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    private String inputMoving() {
        outputView.printInputMove();
        return inputView.readMoving();
    }

    private String inputCommand() {
        outputView.printInputCommand();
        return inputView.readGameCommand();
    }
}
