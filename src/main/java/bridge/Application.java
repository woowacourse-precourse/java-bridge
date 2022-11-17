package bridge;

import java.util.*;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bridgeGame;
    private static int tryCount;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        inputView = new InputView();
        String readValue = inputView.readBridgeSize();
        int size = checkSize(readValue);
        BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);
        final List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        bridgeGame = new BridgeGame();
        outputView = new OutputView();

        String isSuccess = "성공";
        tryCount = 1;
        gameProcess(size, bridge, "성공");
        //if (isRetry == "R")


    }

    public static int checkSize(String str) {
        int size = 0;
        try {
            size = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            //throw new IllegalArgumentException("[ERROR] 다시 시도해 주세요.");
            InputView inputView = new InputView();
            String s = inputView.readBridgeSize();
            checkSize(s);
        }
        return size;
    }

    public static void gameProcess(int size, List<String> bridge, String isSuccess) {
        List<List<String>> userPlaying = new ArrayList<>();
        String isRetry = "";
        for (int i = 0; i < size; i++) {
            String move = inputView.readMoving();
            List<String> currentPlaying = bridgeGame.move(move, bridge.get(i));
            userPlaying.add(currentPlaying);
            outputView.printMap(userPlaying);
            if (i == size - 1)
                outputView.printResult(isSuccess, tryCount);
            if (currentPlaying.contains("X")) {
                isRetry = inputView.readGameCommand();
                isSuccess = "실패";
                break;
            }
        }
    }


}
