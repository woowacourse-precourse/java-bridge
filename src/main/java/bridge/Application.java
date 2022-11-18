package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int level = 0;
        int tryCount = 1;
        int bridgeSize = 0;

        bridgeGame.startGame();
        bridgeGame.printRequestBridgeSizeMessage();

        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            bridgeGame.printRequestBridgeSizeMessage();
            bridgeSize = inputView.readBridgeSize();
        }

        List<String> bridge = bridgeGame.makeBridge(bridgeSize);

        while (level < bridge.size()) {
            bridgeGame.printRequestMovingMessage();
            String moving = inputView.readMoving();
            String makeMap = bridgeGame.makeMap(bridge, moving, level);
            outputView.printMap(makeMap);



            if (makeMap.contains("X")) {
                bridgeGame.printRequestRetryMessage();
                String gameCommand = inputView.readGameCommand();


                if (gameCommand.equals("Q")) {
                    break;
                }
                if (gameCommand.equals("R")) {
                    bridgeGame.retry(level);
                    tryCount++;
                }
                level--;
            }

            level++;
        }
        String result = bridgeGame.getSb1() + "\n" + bridgeGame.getSb2();
        outputView.printResult(result);
        if (level == bridge.size()) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (level != bridge.size()) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: "+tryCount);
    }
}
