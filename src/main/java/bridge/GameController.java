package bridge;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private Bridge bridge;
    private final BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void executeGame() {
        outputView.printOpening();
        makeBridge();
        crossToOtherSide();
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

    private void crossToOtherSide() {
        int matchCount = 0;
        while (matchCount < bridge.getBridgeSize()) {
            outputView.printUserChoiceOpening();
            String choice = inputView.readPositionChoice();

        }
    }
}
