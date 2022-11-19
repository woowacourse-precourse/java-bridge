package bridge.controller;

import bridge.view.InputView;

import java.util.List;

import static bridge.view.OutputView.printMap;

public class BridgeController {

    public static int readBridgeSizeController() {
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

    public static StringBuffer printMapController(List<String> nowBridge, List<String> generatedBridge) {
        return printMap(nowBridge, generatedBridge);
    }
}
