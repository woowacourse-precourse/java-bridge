package bridge;

import java.util.*;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bridgeGame;
    private static BridgeMaker bridgeMaker;
    private static int tryCount;
    private static String isSuccess;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");

        initClass();


        int size = sizeException();


        final List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);


        String isSuccess = "성공";
        tryCount = 1;
        gameProcess(size, bridge, "성공");


    }

    public static void initClass() {
        inputView = new InputView();
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public static int checkSize() {
        String readValue = inputView.readBridgeSize();
        int size;
        try {
            size = Integer.parseInt(readValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력할 수 있습니다.");
        }
        return size;
    }

    public static void checkSizeRange(int size) {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3~20 사이의 숫자여야 합니다.");
    }

    public static int sizeException() {
        int size;
        try {
            size = checkSize();
            checkSizeRange(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            size = sizeException();
        }
        return size;
    }

    public static void gameProcess(int size, List<String> bridge, String isSuccess) {
        List<List<String>> userPlaying = new ArrayList<>();
        System.out.println(userPlaying);
        String isRetry = "";
        for (int i = 0; i < size; i++) {
            String move = inputView.readMoving();
            List<String> currentPlaying = bridgeGame.move(move, bridge.get(i));
            userPlaying.add(currentPlaying);
            outputView.printMap(userPlaying);
            isSuccess = "성공";
            if (currentPlaying.contains("X")) {
                isRetry = inputView.readGameCommand();
                isSuccess = "실패";
                break;
            }
        }
        if (Objects.equals(isRetry, "R")) {
            tryCount++;
            userPlaying.clear();
            gameProcess(size, bridge, isSuccess);
        } else {
            outputView.printResult(isSuccess, tryCount, userPlaying);
        }

    }




}
