package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private static List<String> bridge;
    List<Boolean> currentBridge = new ArrayList<>();

    private static int retryCount = 0;

    public void gameStart() {
        BridgeGame bridgeGame = new BridgeGame();
        boolean play = false;
        boolean gameResult;
        gameSetUp();
        do {
            gameResult = oneGame();
            retryCount++;
            if (gameResult) break;
            String retryCommand = InputView.readGameCommand();
            play = bridgeGame.retry(retryCommand);
        } while (play);
//        System.out.println("retryCount = " + retryCount);
//        System.out.println("gameResult = " + gameResult);
        OutputView.printResult(currentBridge, bridge, retryCount, gameResult);
    }

    private List<String> gameSetUp() {
        OutputView.printGameStartMessage();
        int size = InputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
//        System.out.println("bridge = " + bridge.toString());
        return bridge;
    }

    private boolean oneGame() {
        BridgeGame bridgeGame = new BridgeGame();
//        List<Boolean> currentBridge = new ArrayList<>();
        currentBridge.clear();
        int currentIndex = 0;
        boolean result = true;
        for (int i = 0; i < bridge.size(); i++) {
            String moveCommand = InputView.readMoving();
            result = bridgeGame.move(currentIndex, moveCommand, bridge);
            currentBridge.add(result);
//            System.out.println("currentBridge = " + currentBridge.toString());
            currentIndex++;
            OutputView.printMap(currentBridge, bridge);
            if (!result) return false;
        }
        return true;
    }
}
