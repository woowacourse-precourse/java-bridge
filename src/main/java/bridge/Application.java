package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        String readValue = inputView.readBridgeSize();
        int size = checkSize(readValue);
        BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);
        final List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        List<List<String>> userPlaying = new ArrayList<>();
        String isSuccess = "성공";
        int tryCount = 1;
        for (int i = 0; i<size; i++) {
            String move = inputView.readMoving();
            String result = bridgeGame.move(move, bridge.get(i));
            List<String> currentPlaying = new ArrayList<>();
            currentPlaying.add(move);
            currentPlaying.add(result);
                userPlaying.add(currentPlaying);
            outputView.printMap(userPlaying);
            if (i == size-1) {
                outputView.printResult(isSuccess, tryCount);
            }
            if (Objects.equals(result, "X")) {
                inputView.readGameCommand();
                isSuccess = "실패";
                break;
            }


        }
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
}
