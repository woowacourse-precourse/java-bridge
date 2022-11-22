package bridge.domain.model;

import bridge.domain.constant.Outcome;

public class GameState {

    private boolean gameState;
    private boolean restartState;

    public void initialize() {
        gameState = true;
        restartState = false;
    }

    public void updateGameState(boolean currentGameState) {
        gameState &= currentGameState;
    }

    public boolean getGameState() {
        return gameState;
    }

    public void updateRestartState(boolean currentRestartState) {
        restartState = currentRestartState;
    }

    public String getWordState() {
        return Outcome.getStateWord(gameState);
    }

    public boolean isGameContinue() {
        if (restartState) {
            return true;
        }
        return gameState && restartState;
    }

    public boolean isSingleGameEnd(boolean isGameOver) {
        return (isGameOver && gameState);
    }
}
