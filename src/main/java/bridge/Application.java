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
        BridgeGame bridgeGame = new BridgeGame();

        outputView.printBeforeGame();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        List<Boolean> movingResults = new ArrayList<>();
        int tryCount = 1;

//        for(int i = 0; i < bridge.size(); i++) {
//            System.out.print(bridge.get(i) + " ");
//        }
        try {
            while(!bridgeGame.isSucceed(movingResults, bridge)) {
                String moving = inputView.readMoving();
                boolean movingResult = bridgeGame.move(moving, movingResults, bridge);
                movingResults.add(movingResult);
                outputView.printMap(movingResults, bridge);
                if (movingResult == true) {
                    continue;
                }
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("R")) {
                    movingResults = new ArrayList<>();
                    tryCount++;
                    continue;
                }
                if (gameCommand.equals("Q")) {
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        outputView.printResult(movingResults, bridge, tryCount);
    }
}
