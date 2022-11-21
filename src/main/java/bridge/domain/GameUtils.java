package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;


import java.util.List;

public class GameUtils {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static List<String> buildBridge() {
        int size = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        Validation.correctSize(size, bridge);
        return bridge;
    }

    public static String getGameCommand() {
        return inputView.readGameCommand();
    }

    public static String getMoving() {
        return inputView.readMoving();
    }

    public static void printMoveResult(List<String> bridge, int position, boolean correct) {
        outputView.printMap(bridge, position, correct);
    }

    public static void printGameResult(List<String> bridge, int position, boolean success) {
        outputView.printResult(bridge, position, success);
    }

    public static void printSuccessResult(boolean success, int trial) {
        outputView.printSuccessOrFail(success, trial);
    }
}
