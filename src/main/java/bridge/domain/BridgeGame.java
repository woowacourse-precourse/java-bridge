package bridge.domain;

import bridge.Exception.QuitGameException;
import bridge.Exception.SuccessGameException;


import java.util.List;

public class BridgeGame {
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public StageResult move(String userInput) {
        StageResult stageResult = compareInputWithBridge(userInput);

        return stageResult;
    }

    public StageResult compareInputWithBridge(String userInput) {
        int currentStage = BridgeStage.currentStage();
        String stageAnswer = bridge.get(currentStage);

        if (stageAnswer.equals(userInput)) {
            if (BridgeStage.isFinalStage(bridge.size())) {
                return StageResult.SUCCESS;
            }
            return StageResult.PASS;
        }
        return StageResult.FAIL;
    }

    public void pass() {
        BridgeStage.nextStage();
    }

    public void success() {
        throw new SuccessGameException();
    }

    public void quit() {
        throw new QuitGameException();
    }

    public void retry() {
        BridgeStage.resetStage();
        BridgeStage.increaseRetry();
    }
}
