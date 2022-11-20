package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.view.OutputView.printMap;

public class BridgeController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

    public int gameManagementController(List<String> nowBridge, List<String> generatedBridge) {
        return bridgeGame.gameManagement(nowBridge, generatedBridge);
    }


    // 입력
    public int readBridgeSizeController() {
        int size;
        while (true) {
            try {
                size = InputView.readBridgeSize();
                return size;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static String readMovingController() {
        String pick;
        while (true) {
            try {
                pick = InputView.readMoving();
                return pick;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static String readGameCommandController() {
        while (true) {
            try {
                return InputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }


    // 출력
    public static StringBuffer printMapController(List<String> nowBridge, List<String> generatedBridge) {
        return printMap(nowBridge, generatedBridge);
    }

    public void printResultController(int count, List<String> nowBridge, List<String> generatedBridge) {
        outputView.printResult(count, nowBridge, generatedBridge);
    }
}
