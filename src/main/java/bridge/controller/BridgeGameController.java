package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private static List<String> bridge;
    private static int gameCount = 1;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private boolean gameResult;

    public BridgeGameController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
    }

    public void createBridge() {
        int bridgeSize = InputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void run(){
        int bridgeSize = bridge.size();
        boolean isMoveSuccess;
        List<String> userAnswer = new ArrayList<>();
        for (int moveCount = 0; moveCount < bridgeSize; moveCount++) {
            String moving = InputView.readMoving();
            isMoveSuccess = bridgeGame.move(bridge, moving);
            userAnswer.add(moving);
            OutputView.printMap(bridge,userAnswer);
            if (!isMoveSuccess){
                gameResult = false;
                retry();
                return;
            }
        }
        gameResult = true;
        end();
    }

    public void retry() {
        String gameCommand = InputView.readGameCommand();
        boolean retry = bridgeGame.retry(gameCommand);

        if (retry) {
            gameCount++;
            run();
        }

        end();
    }

    public void end() {
        OutputView.printResult(gameResult, gameCount);
    }
}
