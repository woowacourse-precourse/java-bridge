package controller;

import constant.Number;
import generator.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import model.BridgeGame;
import java.util.List;
import service.BridgeMaker;
import view.InputView;
import view.OutputView;

public class BridgeController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void run() {
        List<List<String>> bothSide = init();
        List<String> bridge = makeBridge();
        BridgeGame.move(bridge, bothSide);
        printResult(bothSide, BridgeGame.tryNumber);
        BridgeGame.clearTryNumber();
    }

    public static List<List<String>> init() {
        List<List<String>> bothSide = new ArrayList<>();
        List<String> downSide = new ArrayList<>(Number.BRIDGE_SIZE_END_INCLUSIVE.getNumber());
        List<String> upSide = new ArrayList<>(Number.BRIDGE_SIZE_END_INCLUSIVE.getNumber());

        bothSide.add(downSide);
        bothSide.add(upSide);
        return bothSide;
    }

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

    public static void printStart() {
        OutputView.printStart();
    }

    public static void printMap(List<List<String>> bothSide) {
        outputView.printMap(bothSide);
    }

    public static void printResult(List<List<String>> bothSide, int tryNumber) {
        outputView.printResult(bothSide, tryNumber);
    }

    public static void printRetryOrQuit(String retryOrQuit) {
        outputView.printRequestRetryOrQuit();
        outputView.printUserRetryOrQuit(retryOrQuit);
    }
}
