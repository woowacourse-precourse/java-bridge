package bridge;

import java.util.*;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeMaker bridgeMaker;

    public static void main(String[] args) {
        initClass();
        System.out.println("다리 건너기 게임을 시작합니다.");
        final List<String> bridge = bridgeMaker.makeBridge(inputSize());
        System.out.println(bridge);
        BridgeGame.gameProcess(bridge);
    }

    public static void initClass() {
        inputView = new InputView();
        outputView = new OutputView();
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public static int inputSize() {
        String readValue = inputView.readBridgeSize();
        return ExceptionHandler.sizeExceptionHandler(readValue);
    }

    public static String inputMove() {
        String move = inputView.readMoving();
        ExceptionHandler.moveExceptionHandler(move);
        return move;
    }

    public static void printMap(List<List<String>> userPlaying) {
        outputView.printMap(userPlaying);
    }

    public static String inputGameCommand() {
        String gameCommand = inputView.readGameCommand();
        ExceptionHandler.gameCommandExceptionHandler(gameCommand);
        return gameCommand;
    }

    public static void printResult(String isSuccess, int tryCount, List<List<String>> userPlaying) {
        outputView.printResult(isSuccess, tryCount, userPlaying);
    }
}
