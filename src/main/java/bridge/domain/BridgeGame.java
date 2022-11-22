package bridge.domain;

import bridge.utils.enums.GameState;
import bridge.utils.Validator;

import java.util.List;

public class BridgeGame {
    private final List<String> answerBridge;
    private final User user;
    private final Result result;

    public BridgeGame(List<String> answerBridge, User user, Result result) {
        this.answerBridge = answerBridge;
        this.user = user;
        this.result = result;
    }

    public boolean move(String moveInput) {
        validateMoveInput(moveInput);
        user.move();
        result.updateResult(user.getMoveCount(), moveInput, answerBridge);
        return result.isMoveSuccess();
    }

    public String getPlayResult() {
        return result.getGameState();
    }

    public List<String> getFinalResult() {
        String trialCount = user.getTrial();
        String winningResult = result.getWinningResult();
        return List.of(winningResult, trialCount);
    }

    public void retry() {
        user.retry();
    }

    private void validateMoveInput(String moveInput) {
        Validator.checkMoveInput(moveInput);
    }
}
