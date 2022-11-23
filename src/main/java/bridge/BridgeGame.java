package bridge;

import java.util.List;

public class BridgeGame {

    private int placeNumber = 0;
    private String restart = "";
    private int gameRepeatCount = 0;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMapGenerator bridgeMapGenerator = new BridgeMapGenerator();

    public void playGame(List<String> bridge) {
        while (restart == null || !restart.equals("Q")) {
            gameRepeatCount++;
            bridgeMapGenerator.clearAllBridgeMap();
            crossBridge(bridge);
            retry(bridge.size());
        }
        outputView.printResult(bridgeMapGenerator.getBridgeMap(), checkSuccessOrNot(bridge.size()), gameRepeatCount);
    }

    private void crossBridge(List<String> bridge) {
        boolean match = true;
        int inputCount = 0;
        while (match && inputCount < bridge.size()) {
            String playerMoving = inputView.readMoving();
            bridgeMapGenerator.generateBridgeMap(playerMoving, bridge.get(inputCount));
            outputView.printBridgeMap(bridgeMapGenerator.getBridgeMap());
            match = checkMissMatching(playerMoving, bridge.get(inputCount));
            inputCount++;
        }
    }

    private String checkSuccessOrNot(int bridgeSize) {
        if (placeNumber == bridgeSize) {
            return "성공";
        }
        return "실패";
    }

    private boolean checkMissMatching(String playerMoving, String eachBridge) {
        if (!playerMoving.equals(eachBridge)) {
            returnToStartPoint();
            return false;
        }
        move();
        return true;
    }

    private void returnToStartPoint() {
        placeNumber = 0;
    }

    private void move() {
        placeNumber++;
    }

    private void retry(int bridgeSize) {
        restart = "Q";
        if (placeNumber != bridgeSize) {
            restart = inputView.readGameCommand();
        }
    }
}
