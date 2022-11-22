package bridge.domain;

import bridge.utils.enums.GameState;
import bridge.utils.Validator;

import java.util.List;

public class BridgeGame {
    List<String> answerBridge;
    User user;
    Result result;

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

    public void retry() {
        user.move();
    }

    private void validateMoveInput(String moveInput) {
        Validator.checkMoveInput(moveInput);
    }
}
