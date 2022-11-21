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
        OutputView.bridgeLengthMessage();

        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            OutputView.bridgeLengthMessage();
            bridgeSize = inputView.readBridgeSize();
        }

        List<String> bridge = bridgeGame.makeBridge(bridgeSize);

        while (size < bridge.size()) {
            OutputView.moveStepMessage();
            String search = inputView.readSearch();
            String makeMap = bridgeGame.move(size, bridge, search);
            outputView.printMap(makeMap);

            if (makeMap.contains("X")) {
                OutputView.retryMessage();
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
