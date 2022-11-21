package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.Domain.BridgeNumberGenerator;
import bridge.Domain.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    List<String> bridge = new ArrayList<>();
    public void start() {
        int lengthOfBridge = gameStart();
        selectMoving(lengthOfBridge);
    }

    public int gameStart() {
        outputView.printGameStart();
        outputView.printEmptyLine();
        int lengthOfBridge = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(lengthOfBridge);
        outputView.printEmptyLine();
        return lengthOfBridge;
    }

    public void selectMoving(int lengthOfBridge) {
        for (int i = 0; i < lengthOfBridge; i++) {
            String userMove = InputView.readMoving();
            outputView.setUpAndDownSide(userMove, bridge.get(i));
            boolean isCorrect = bridgeGame.move(bridge, userMove);
            outputView.printMap();
            outputView.printEmptyLine();
            if (!isCorrect) break;
        }
    }

    public void selectQuitOrRestart(int lengthOfBridge) {
        String restartOrQuit = InputView.readGameCommand();
        if (restartOrQuit.equals("R")) {
            restartGame(lengthOfBridge);
        }
        if (restartOrQuit.equals("Q")) {
            quitGame();
        }
    }

    public void restartGame(int lengthOfBridge) {
        bridgeGame.retry();
        selectMoving(lengthOfBridge);
    }
}
