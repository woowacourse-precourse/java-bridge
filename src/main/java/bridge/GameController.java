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
        makeBridge();
    }

    private void makeBridge() {
        outputView.printBrideSizeOpening();
        try {
            bridge = new Bridge(inputView.readBridgeSize());
            outputView.printEmptyLine();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            makeBridge();
        }
    }
}
