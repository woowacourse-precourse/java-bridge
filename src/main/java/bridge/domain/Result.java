package bridge.domain;

import bridge.utils.enums.GameState;

import java.util.List;

public class Result {
    private boolean moveSuccess;
    private boolean gameEnd;

    public void updateResult(int moveCount, String moveInput, List<String> answerBridge) {
        int lastIndex = moveCount - 1;
        updateMoveSuccess(answerBridge, lastIndex, moveInput);
        updateRemainBridge(moveCount, answerBridge);
    }

    public boolean isMoveSuccess() {
        return moveSuccess;
    }

    public String getGameState() {
        if (!moveSuccess) {
            return GameState.LOOSE.name();
        }
        if (gameEnd) {
            return GameState.WIN.name();
        }
        return GameState.PLAYING.name();
    }

    public String getWinningResult() {
        if (!moveSuccess) {
            return GameState.LOOSE.getLabel();
        }
        return GameState.WIN.getLabel();
    }

    private void updateMoveSuccess(List<String> answerBridge, int lastIndex, String moveInput) {
        moveSuccess = answerBridge.get(lastIndex).equals(moveInput);
    }

    private void updateRemainBridge(int moveCount, List<String> answerBridge) {
        gameEnd = moveCount == answerBridge.size();
    }
}
