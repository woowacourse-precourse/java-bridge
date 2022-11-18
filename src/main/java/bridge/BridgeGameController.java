package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private static final String WIN_GAME = "성공";
    private static final String LOSE_GAME = "실패";

    private int trials = 1;
    private List<String> bridge;
    private String moving;
    private int index;
    private boolean retry = true;
    private final List<String> movingData = new ArrayList<>();
    private final List<String> upBridgeResult = new ArrayList<>();
    private final List<String> downBridgeResult = new ArrayList<>();

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        OutputView.printStart();
        getBridge();
        while (true) {
            moveBridge();
            if (!bridgeGame.isMovingCorrect(bridge, index, moving)) {
                retryOrQuit();
            }
            if (!retry) {
                break;
            }
            if (winBridgeGame()) {
                printResult(WIN_GAME);
                break;
            }
        }
    }

    public void moveBridge() {
        getMoving();
        updateBridgeResultData();
        OutputView.printMap(upBridgeResult, downBridgeResult);
    }

    private void getBridge() {
        try {
            int size = InputView.readBridgeSize();
            this.bridge = bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            getBridge();
        }
    }

    private void getMoving() {
        try {
            String moving = bridgeGame.move(InputView.readMoving());
            movingData.add(moving);
            this.moving = moving;
            this.index = movingData.size() - 1;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            getMoving();
        }
    }

    private void updateBridgeResultData() {
        upBridgeResult.add(bridgeGame.getUpBridgeResult(bridge, index, moving));
        downBridgeResult.add(bridgeGame.getDownBridgeResult(bridge, index, moving));
    }

    private void retryOrQuit() {
        askRetry();
        if (retry) {
            resetData();
        }
        if (!retry) {
            printResult(LOSE_GAME);
        }
    }

    private void askRetry() {
        try {
            this.retry = bridgeGame.retry(InputView.readGameCommand());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            askRetry();
        }
    }

    private void resetData() {
        trials++;
        movingData.remove(index);
        upBridgeResult.remove(index);
        downBridgeResult.remove(index);
    }

    private boolean winBridgeGame() {
        return bridgeGame.isMovingCorrect(bridge, index, moving) && bridge.size() == movingData.size();
    }

    private void printResult(String gameResult) {
        OutputView.printLastMap(upBridgeResult, downBridgeResult);
        OutputView.printResult(gameResult, trials);
    }
}
