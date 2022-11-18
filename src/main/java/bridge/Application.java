package bridge;

import java.util.*;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bridgeGame;
    private static BridgeMaker bridgeMaker;
    private static int tryCount;
    private static String isSuccess = "성공";

    public static void main(String[] args) {
        initClass();
        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputSize();

        final List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        tryCount = 1;
        gameProcess(bridge);
    }

    public static void initClass() {
        inputView = new InputView();
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
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

    public static void gameProcess(List<String> bridge) {
        List<List<String>> userPlaying = new ArrayList<>();
        String isRetry = "";
        for (String s : bridge) {
            List<String> currentPlaying = bridgeGame.move(inputView.readMoving(), s);
            userPlaying.add(currentPlaying);
            outputView.printMap(userPlaying);
            if (currentPlaying.contains("X")) {
                isRetry = inputView.readGameCommand();
                isSuccess = "실패";
                break;
            }
        }
        gameRetry(isRetry, userPlaying, bridge);
    }

    //TODO BridgeGame으로 리팩토링
    public static void gameRetry(String isRetry, List<List<String>> userPlaying, List<String> bridge) {
        if (Objects.equals(isRetry, "R")) {
            tryCount++;
            userPlaying.clear();
            gameProcess(bridge);
        } else {
            outputView.printResult(isSuccess, tryCount, userPlaying);
        }
    }




}
