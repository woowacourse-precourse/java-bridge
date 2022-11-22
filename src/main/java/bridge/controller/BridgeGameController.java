package bridge.controller;

import bridge.model.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.Map;

public class BridgeGameController {
    private final InputView INPUT_VIEW;
    private final OutputView OUTPUT_VIEW;
    private BridgeGame bridgeGame;
    private int count;

    public BridgeGameController() {
        this.INPUT_VIEW = new InputView();
        this.OUTPUT_VIEW = new OutputView();
        this.count = 0;
    }

    public void startGame() {
        OUTPUT_VIEW.printStartMessage();
        int bridgeSize = INPUT_VIEW.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);

        doGame(bridgeSize);
    }

    private void doGame(int bridgeSize) {
        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = INPUT_VIEW.readMoving();
            boolean isWinning = bridgeGame.move(moveAnswer, i);

            OUTPUT_VIEW.printMap(bridgeGame.getMapMaker().getResults());

            if (!isWinning) {
                count++;
                String retryAnswer = INPUT_VIEW.readGameCommand();

                if (bridgeGame.retry(retryAnswer)) {
                    doGame(bridgeSize);
                    return;
                }

                endGame(false, bridgeGame.getMapMaker().getResults());
                return;
            }
        }
        count++;
        endGame(true, bridgeGame.getMapMaker().getResults());
    }

    private void endGame(boolean isWinning, Map<String, List<String>> results) {
        OUTPUT_VIEW.printResult(isWinning, count, results);
    }

}
