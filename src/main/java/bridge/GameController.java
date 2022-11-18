package bridge;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Bridge bridge;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void executeGame() {
        outputView.printOpening();
        bridge = getBridgeInput();

    }

    private Bridge getBridgeInput() {
        try {
            bridge = new Bridge(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            getBridgeInput();
        }
        return bridge;
    }
}
