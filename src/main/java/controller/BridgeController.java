package controller;

import generator.BridgeRandomNumberGenerator;
import service.BridgeMaker;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BridgeController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static List<String> makeBridge() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        printBridgeSize(size);
        return bridge;
    }

    public static String getMoving() {
        return inputView.readMoving();
    }

    public static String getGameCommand() {
        return inputView.readGameCommand();
    }

    public static void printBridgeSize(int size) {
        outputView.printRequestBridgeSize();
        outputView.printBridgeSize(size);
    }

    public static void printMoving(String path) {
        outputView.printRequestMove();
        outputView.printUserPath(path);
    }

    public static void printMap(List<String> upSide, List<String> downSide) {
        outputView.printMap(upSide, downSide);
    }

    public static void printResult(List<String> upSide, List<String> downSide, int countTryNumber) {
        outputView.printResult(upSide, downSide, countTryNumber);
    }

    public static void printRetryOrQuit(String retryOrQuit) {
        outputView.printRequestRetryOrQuit();
        outputView.printUserRetryOrQuit(retryOrQuit);
    }
}
