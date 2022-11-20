package bridge;

import java.util.Collections;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final GameStatus gameStatus;

    private BridgeGame bridgeGame;
    private List<List<String>> bridgeValues;
    private int bridgeSize;


    public BridgeGameController(BridgeMaker bridgeMaker) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = bridgeMaker;
        this.gameStatus = new GameStatus();
    }

    public void initBridgeGame() {
        outputView.printGameStart();
        bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(gameStatus, Collections.emptyList(), bridgeSize);
    }

    public void playBridgeGame() {
        while (true) {
            if (IsBridgeGameEnd()) {
                break;
            }
        }
    }

    public void printFinalResult() {
        outputView.printResult(bridgeValues, bridgeGame.getGameStatus());
    }

    private boolean IsBridgeGameEnd() {
        crossBridge(bridgeSize);
        if (gameStatus.isGameWon()) {
            return true;
        }
        String retryStatus = inputView.readGameCommand();
        if (!bridgeGame.retry(retryStatus)) {
            return true;
        }
        return false;
    }

    private void crossBridge(int bridgeSize) {
        for (int i = 0; i < bridgeSize; i++) {
            String moveTo = inputView.readMoving();
            bridgeGame.move(moveTo);
            bridgeValues = bridgeGame.decideBridgeValues();
            outputView.printMap(bridgeValues);
            if (bridgeGame.isGameEnd()) {
                break;
            }
        }
    }
}

