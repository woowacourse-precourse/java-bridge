package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);



//        for(int i = 0; i < bridge.size(); i++) {
//            System.out.print(bridge.get(i) + " ");
//        }
        try {
            outputView.printBeforeGame();
            int bridgeSize = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            BridgeGame bridgeGame = new BridgeGame(bridge);

            while(!bridgeGame.isSucceed()) {
                String moving = inputView.readMoving();
                bridgeGame.move(moving);
                outputView.printMap(bridgeGame);
                if (bridgeGame.getLastMovingResult()) {
                    continue;
                }
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("R")) {
                    bridgeGame.retry();
                    continue;
                }
                if (gameCommand.equals("Q")) {
                    break;
                }
            }
            outputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
