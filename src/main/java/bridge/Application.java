package bridge;

import java.util.Collections;
import java.util.List;

public class Application {
    public static int size = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int tryCount = 1;
        int bridgeSize = 0;

        bridgeGame.startGame();
        outputView.bridgeLengthMessage();

        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.bridgeLengthMessage();
            bridgeSize = inputView.readBridgeSize();
        }

        List<String> bridge = bridgeGame.makeBridge(bridgeSize);

        while (size < bridge.size()) {
            outputView.moveStepMessage();
            String search = inputView.readSearch();
            String makeMap = bridgeGame.move(bridge, search, size);
            outputView.printMap(makeMap);

            if (makeMap.contains("X")) {
                outputView.retryMessage();
                String gameCommand = inputView.readGameCommand();


                if (gameCommand.equals("Q")) {
                    break;
                }
                if (gameCommand.equals("R")) {
                    bridgeGame.retry(size);
                    tryCount++;
                }
                size--;
            }

            size++;

    }

        String result = bridgeGame.getSb1() + "\n" + bridgeGame.getSb2();
        outputView.printResult(result);
        if (size == bridge.size()) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (size != bridge.size()) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: "+tryCount);
    }
}
