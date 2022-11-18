package bridge.domain;

import bridge.utils.Validator;

import java.util.List;

public class BridgeGame {
    List<String> answerBridge;
    User user;

    public BridgeGame(List<String> answerBridge, User user) {
        this.answerBridge = answerBridge;
        this.user = user;
    }

    public boolean move(String moveInput) {
        validateMoveInput(moveInput);

        user.move(moveInput);

        return checkMoveSuccess(moveInput);
    }

    public void retry() {
    }

    private void validateMoveInput(String moveInput) {
        Validator.checkMoveInput(moveInput);
    }

    private boolean checkMoveSuccess(String moveInput) {
        int currentIndex = user.getMoveCount() - 1;
        return moveInput.equals(answerBridge.get(currentIndex));
    }
}
