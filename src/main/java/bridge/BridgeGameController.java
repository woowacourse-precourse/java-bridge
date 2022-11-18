package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private static final String WIN_GAME = "성공";
    private static final String LOSE_GAME = "실패";

    private int trials = 1;
    private final List<String> movingData = new ArrayList<>();
    private final List<String> upBridgeResult = new ArrayList<>();
    private final List<String> downBridgeResult = new ArrayList<>();

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        setGame();
    }

    public void setGame() {
        OutputView.printStart();
        List<String> bridge = getBridge();
        while (true) {
            String moving = getMoving(bridge);
            int index = movingData.size() - 1;
            OutputView.printMap(upBridgeResult, downBridgeResult);
            if (!bridgeGame.move(bridge, index, moving) && retry()) {
                reset(index);
                continue;
            }
            if (!bridgeGame.move(bridge, index, moving) && !retry()) {
                printResult(LOSE_GAME);
                break;
            }
            if (winBridgeGame(bridge, index, moving)) {
                printResult(WIN_GAME);
                break;
            }
        }
    }

    private List<String> getBridge() {
        try {
            int size = InputView.readBridgeSize();
            return bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return getBridge();
        }
    }

    private String getMoving(List<String> bridge) {
        try {
            String moving = InputView.readMoving();
            movingData.add(moving);
            updateMovingData(bridge, movingData.size() - 1, moving);
            return moving;
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            reset(movingData.size() - 1);
            return getMoving(bridge);
        }
    }

    private void updateMovingData(List<String> bridge, int index, String input) {
        upBridgeResult.add(bridgeGame.getUpBridgeResult(bridge, index, input));
        downBridgeResult.add(bridgeGame.getDownBridgeResult(bridge, index, input));
    }

    private boolean retry() {
        boolean retry = true;
        try {
            retry = bridgeGame.retry(InputView.readGameCommand());
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            retry();
        }
        return retry;
    }

    private void reset(int index) {
        trials++;
        movingData.remove(index);
        upBridgeResult.remove(index);
        downBridgeResult.remove(index);
    }

    private boolean winBridgeGame(List<String> bridge, int index, String input) {
        return bridgeGame.move(bridge, index, input) && bridge.size() == movingData.size();
    }

    private void printResult(String gameResult) {
        OutputView.printLastMap(upBridgeResult, downBridgeResult);
        OutputView.printResult(gameResult, trials);
    }
}
