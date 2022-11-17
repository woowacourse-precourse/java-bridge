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

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        setGame();
    }

    public void setGame() {
        outputView.printStart();
        List<String> bridge = getBridge();
        while (true) {
            String moving = getMoving();
            int index = movingData.size() - 1;
            updateMovingData(bridge, index, moving);
            outputView.printMap(upBridgeResult, downBridgeResult);
            if (winBridgeGame(bridge, index, moving)) {
                break;
            }
        }
    }

    private List<String> getBridge() {
        List<String> bridge = new ArrayList<>();
        int size;
        try {
            size = inputView.readBridgeSize();
            bridge = bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            getBridge();
        }
        return bridge;
    }

    private String getMoving() {
        String moving = null;
        try {
            moving = inputView.readMoving();
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            getMoving();
        }
        movingData.add(moving);
        return moving;
    }

    private void updateMovingData(List<String> bridge, int index, String input) {
        try {
            upBridgeResult.add(bridgeGame.getUpBridgeResult(bridge, index, input));
            downBridgeResult.add(bridgeGame.getDownBridgeResult(bridge, index, input));
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            getMoving();
        }
    }

    private boolean winBridgeGame(List<String> bridge, int index, String input) {
        if (bridgeGame.isMovingCorrect(bridge, index, input) && bridge.size() == movingData.size()) {
            outputView.printLastMap(upBridgeResult, downBridgeResult);
            outputView.printResult(WIN_GAME, trials);
        }
        return false;
    }

}
