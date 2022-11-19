package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        String gameCommand = "R";
        boolean result = true;
        int gameCount = 0;
        while (gameCommand.equals("R")) {
            gameCount++;
            bridgeGame.listClear(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
            for (int i = 0; i < bridgeSize; i++) {
                String moving = inputView.readMoving();
                 result = bridgeGame.move(moving, bridge, i);
                outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge(), i);
                if (result == false) {
                    gameCommand = inputView.readGameCommand();
                    break;
                }
                gameCommand = "Q";
            }
        }
        outputView.printResult(result, gameCount);
    }
}
