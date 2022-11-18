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

        return checkMoveSuccess();
    }

    public void retry() {
    }

    public boolean checkMoveSuccess() {
        int lastIndex = user.getMoveCount() - 1;
        String lastMove = user.getLastMove();
        return lastMove.equals(answerBridge.get(lastIndex));
    }

    private void validateMoveInput(String moveInput) {
        Validator.checkMoveInput(moveInput);
    }
}
