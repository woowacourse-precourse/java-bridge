
package bridge;


import java.util.ArrayList;
import java.util.List;

import static bridge.Constants.CommandMark.*;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private boolean gaming = true;
    private int bridgeNum = 0;
    private int tryCount = 1;

    public void start() {
        outputView.printStart();
        int bridgeSize = inputBridgeSize();
        List<String> correctBridge = prepareBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame();
        List<List<String>> bridgeMap = play(bridgeSize, bridgeGame, correctBridge);
        outputView.printResult(bridgeMap, bridgeGame.isCorrectMove(), this.tryCount);
    }

    private List<String> prepareBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private List<List<String>> play(int bridgeSize, BridgeGame bridgeGame, List<String> correctBridge) {
        List<List<String>> bridgeMap = new ArrayList<>();
        while (bridgeNum < bridgeSize && gaming) {
            String moving = inputMoving();
            bridgeMap = bridgeGame.move(bridgeNum, moving, correctBridge);
            outputView.printMap(bridgeMap);

            if (bridgeGame.isCorrectMove()) bridgeNum++;
            if (!bridgeGame.isCorrectMove()) failed(bridgeGame);
        }
        return bridgeMap;
    }

    private void failed(BridgeGame bridgeGame) {
        String command = inputCommand();
        if (command.equals(RETRY.mark())) {
            bridgeGame.retry();
            tryCount += 1;
            bridgeNum = 0;
        }
        if (command.equals(QUIT.mark())) {
            gaming = false;
        }
    }

    private int inputBridgeSize() {
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    private String inputMoving() {
        outputView.printInputMoving();
        return inputView.readMoving();
    }

    private String inputCommand() {
        outputView.printInputCommand();
        return inputView.readGameCommand();
    }
}