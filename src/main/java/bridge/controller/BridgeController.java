package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.Setting;
import bridge.view.OutputView;

public class BridgeController {
    private static BridgeGame bridgeGame;
    private static BridgeMap bridgeMap;

    public static void startGame() {
        OutputView.printStartMessage();
        int bridgeSize = InputController.requestBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker, bridgeSize);
        bridgeMap = new BridgeMap(bridgeGame);
    }

    public static void startRound() {
        while (bridgeGame.isGameContinue()) {
            String direction = InputController.requestMovingDirection();
            bridgeGame.move(direction);
            printBridgeMap(direction);
            if (checkIsGameFinish()) {
                break;
            }
        }
    }

    public static void restartOrQuitGame() {
        String gameCommand = InputController.requestGameCommand();
        if (gameCommand.equals(Setting.GAME_RESTART)) {
            bridgeGame.retry();
            bridgeMap = new BridgeMap(bridgeGame);
            return;
        }
        OutputView.printResult(bridgeMap, bridgeGame);
    }

    private static void printBridgeMap(String direction) {
        bridgeMap.makeMap(direction);
        if (bridgeGame.isGameContinue()) {
            OutputView.printMap(bridgeMap);
        }
        if (bridgeGame.isGameFinish()) {
            OutputView.printResult(bridgeMap, bridgeGame);
        }
    }

    public static boolean checkIsGameContinue() {
        return bridgeGame.isGameContinue();
    }

    public static boolean checkIsGameFinish() {
        return bridgeGame.isGameFinish();
    }
}