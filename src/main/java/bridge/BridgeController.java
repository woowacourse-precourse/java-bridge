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
        printResult();
    }

    private void init() {
        bridgeView.gameStartMessage();
        int bridgeSize = bridgeView.inputBridgeSizeMessage();
        bridgeGame.create(bridgeSize);
    }

    private void loop() {
        while (true) {
            GameSymbol gameSymbol = moveBridge();
            if (gameSymbol == GameSymbol.QUIT) {
                break;
            }
            if (gameSymbol == GameSymbol.RETRY) {
                bridgeGame.retry();
            }
            if (bridgeGame.allTry()) {
                break;
            }
        }
    }

    private GameSymbol moveBridge() {
        bridgeGame.move(bridgeView.inputMoveCommandMessage());
        bridgeView.printMoveResult(bridgeGame.printLines());
        if (bridgeGame.getResultSymbol() == ResultSymbol.FAIL) {
            return bridgeView.inputRetryCommandMessage();
        }
        return GameSymbol.NOTHING;
    }

    private void printResult() {
        bridgeView.printGameResult(bridgeGame.printLines(), bridgeGame.getResultSymbol(), bridgeGame.getGameTryCount());
    }
}
