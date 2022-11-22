package bridge.controller;

import bridge.BridgeGame;
import bridge.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private final BridgeGame bridgeGame;
    private final Result result;
    private List<String> bridge;
    private int countTry;
    private int bridgeSize;
    private boolean retry;

    public GameController(BridgeGame bridgeGame, Result result) {
        this.countTry = 0;
        this.bridgeGame = bridgeGame;
        this.result = result;
    }

    public void playGame() {
        setEternalThing();

        do {
            round();
            countTry++;
            successResult();
            failedAndEndGame();
            bridgeGame.reset();
        } while (retry);
    }

    private void round() {
        do {
            bridgeGame.move(InputView.readMoving());
            result.updateBridge(bridge, bridgeGame.getMoves());
            OutputView.printMap(result.getTopBridgeResult(), result.getBottomBridgeResult());
        } while ((!isFailed()) && (bridgeGame.getMoves().size() < bridgeSize));
    }

    private boolean isFailed() {
        return result.findFail(bridge, bridgeGame.getMoves());
    }

    private void setBridge(BridgeController bridgeController) {
        this.bridge = bridgeController.bridge();
    }

    private void setBridgeSize(BridgeController bridgeController) {
        this.bridgeSize = bridgeController.getBridgeSize();
    }

    private void setEternalThing() {
        BridgeController bridgeController = new BridgeController();
        setBridge(bridgeController);
        setBridgeSize(bridgeController);
    }

    private void failedAndEndGame() {
        if (bridgeGame.getMoves().size() < bridgeSize) {
            retry = bridgeGame.retry();

            if (!retry) {
                OutputView.printEndResult();
                OutputView.printResult(FAIL);
                OutputView.printTotalAttempts(countTry);
            }
        }
    }

    private void successResult() {
        if (bridge.size() == bridgeGame.getMoves().size()) {
            OutputView.printEndResult();
            OutputView.printResult(SUCCESS);
            OutputView.printTotalAttempts(countTry);
        }
    }
}
