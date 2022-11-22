package bridge;

public class InputController {
    private static InputView inputView = new InputView();

    public int inputBridgeSize() {
        return inputView.readBridgeSize();
    }

    public String inputMoving() {
        return inputView.readMoving();
    }

    public String inputGameCommand() {
        return inputView.readGameCommand();
    }
}
