package bridge;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final BridgeResults bridgeResults;
    private final OutputView outputView;
    private final BridgeIndex index;

    public BridgeController(InputView inputView) {
        this.inputView = inputView;
        this.bridgeResults = new BridgeResults();
        this.outputView = new OutputView();
        this.index = new BridgeIndex();
    }

    public void run(int bridgeSize, List<String> randomBridge) {
        int gameCount = 1;
        boolean gameEndButton = false;
        BridgeGame bridgeGame = new BridgeGame(randomBridge, bridgeResults);
        while (!index.endGame(bridgeSize) && !gameEndButton) {
            boolean compareBridgeLocationResult = bridgeGame.move(inputView.readMoving(), bridgeResults, index);
            outputView.printMap(bridgeResults);
            if (!compareBridgeLocationResult) {
                gameEndButton = bridgeGame.retry(inputView.readGameCommand());
                gameCount++;
            }
        }
        outputView.printResult(bridgeResults, gameEndButton, gameCount);
    }
}
