package bridge;

import java.util.*;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeMaker bridgeMaker;

    public static void main(String[] args) {
        initClass();
        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputSize();

        final List<String> bridge = bridgeMaker.makeBridge(size);
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
        int size;
        try {
            size = checkSizeType(readValue);
            checkSizeRange(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            size = inputSize();
        }
        return size;
    }

    public static int checkSizeType(String str) {
        int size;
        try {
            size = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력할 수 있습니다.");
        }
        return size;
    }

    public static void checkSizeRange(int size) {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3~20 사이의 숫자여야 합니다.");
    }

    public static String inputMove() {
        return inputView.readMoving();
    }

    public static void printMap(List<List<String>> userPlaying) {
        outputView.printMap(userPlaying);
    }

    public static String inputRetryCommand() {
        return inputView.readGameCommand();
    }

    public static void printResult(String isSuccess, int tryCount, List<List<String>> userPlaying) {
        outputView.printResult(isSuccess, tryCount, userPlaying);
    }


}
