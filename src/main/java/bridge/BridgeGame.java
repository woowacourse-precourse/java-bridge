package bridge;

import java.util.List;

public class BridgeGame {

    private int placeNumber = 0;
    private String restart = "";
    private int gameRepeatCount = 0;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMapGenerator bridgeMapGenerator = new BridgeMapGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public void playGame() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while (restart == null || !restart.equals("Q")) {
            gameRepeatCount++;
            clearBridgeMap();
            crossBridge(bridge);
            retry(bridgeSize);
        }
        outputView.printResult(bridgeMapGenerator.getBridgeMap(), checkSuccessOrNot(bridgeSize), gameRepeatCount);
    }

    public void clearBridgeMap() {
        bridgeMapGenerator.upBridgeMap.clear();
        bridgeMapGenerator.downBridgeMap.clear();
    }

    private void crossBridge(List<String> bridge) {
        String playerMoving;
        boolean match = true;
        int inputCount = 0;
        while (match && inputCount < bridge.size()) {
            playerMoving = inputView.readMoving();
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

    public void move() {
        placeNumber++;
    }

    public void returnToStartPoint() {
        placeNumber = 0;
    }

    public void retry(int bridgeSize) {
        restart = "Q";
        if (placeNumber != bridgeSize) {
            restart = inputView.readGameCommand();
        }
    }
}
