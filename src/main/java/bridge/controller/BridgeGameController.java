package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.utils.constants.GameConstants;
import bridge.utils.constants.Result;
import bridge.utils.output.BridgeStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private static List<String> bridge;
    private static int gameCount = 1;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final BridgeStatus bridgeStatus;
    private String gameResult;

    public BridgeGameController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
        this.bridgeStatus = new BridgeStatus();
    }

    public void createBridge() {
        int bridgeSize = InputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void run(){
        if (isPassBridge()) {
            gameResult = GameConstants.SUCCESS;
            end();
            return;
        }
        gameResult = GameConstants.FAIL;
        retry();
    }

    private boolean isPassBridge() {
        List<Result> results = new ArrayList<>();
        for (String correctStep : bridge) {
            boolean isMoveSuccess = oneStepMove(results, correctStep);

            if (!isMoveSuccess){
                return false;
            }
        }
        return true;
    }

    private boolean oneStepMove(List<Result> results, String correctStep) {
        String moving = InputView.readMoving();
        boolean isMoveSuccess = bridgeGame.move(correctStep, moving);

        results.add(Result.getResult(moving, isMoveSuccess));
        bridgeStatus.init(results);

        OutputView.printMap(bridgeStatus.toString());
        return isMoveSuccess;
    }

    public void retry() {
        String gameCommand = InputView.readGameCommand();
        boolean retry = bridgeGame.retry(gameCommand);

        if (retry) {
            gameCount++;
            run();
            return;
        }

        end();
    }

    public void end() {
        OutputView.printResult(bridgeStatus.toString(), gameResult, gameCount);
    }
}
