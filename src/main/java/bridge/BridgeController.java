package bridge;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final BridgeView bridgeView;

    public BridgeController(BridgeGame bridgeGame, BridgeView bridgeView) {
        this.bridgeGame = bridgeGame;
        this.bridgeView = bridgeView;
    }

    public void start() {
        init();
        loop();
    }

    private void init() {
        bridgeView.gameStartMessage();
        int bridgeSize = bridgeView.inputBridgeSizeMessage();
        bridgeGame.create(bridgeSize);
    }

    private void loop() {
        while (true) {
            String moveCommand = bridgeView.inputMoveCommandMessage();
            ResultSymbol resultSymbol = bridgeGame.move(moveCommand);
            bridgeView.printMoveResult(bridgeGame.printLines());
            if (ResultSymbol.FAIL == resultSymbol) {
                String retryCommand = bridgeView.inputRetryCommandMessage();
                if (retryCommand.equals("R")) {
                    bridgeGame.retry();
                }
                if (retryCommand.equals("Q")) {
                    break;
                }
            }
            if (bridgeGame.allTry()) {
                break;
            }
        }
    }
}
