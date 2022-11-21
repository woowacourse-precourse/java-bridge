package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final OutputView outputView = new OutputView();

    // 입력
    public int readBridgeSizeController() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
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

    public String readMovingController() {
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

    public String readGameCommandController() {
        while (true) {
            try {
                return InputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }


    // 출력
    public StringBuffer printMapController(List<String> nowBridge, List<String> generatedBridge) {
        return outputView.printMap(nowBridge, generatedBridge);
    }

    public void printResultController(int count, StringBuffer bridgeScreen, String gameSuccess) {
        outputView.printResult(count, bridgeScreen, gameSuccess);
    }
}
