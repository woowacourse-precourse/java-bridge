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

        while(!bridgeGame.isEnd()) {
            String moving = inputView.readMoving();
            Boolean movingResult = bridgeGame.move(moving, movingResults, bridge);
            movingResults.add(movingResult);
            outputView.printMap(movingResults, bridge);
            if (movingResult == true) {
                continue;
            }
            String gameCommand = inputView.readGameCommand();
            if (gameCommand == "R") {
                movingResults = new ArrayList<>();
                tryCount++;
                continue;
            }
            if (gameCommand == "Q") {
                break;
            }
        }
        outputView.printResult(movingResults, bridge, tryCount);
    }
}
