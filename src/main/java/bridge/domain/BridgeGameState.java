package bridge.domain;

import static bridge.domain.Constants.*;

public class BridgeGameState {

    private int round = BRIDGE_GAME_ROUND_INIT;
    private int totalGameAttempts = BRIDGE_GAME_ATTEMPTS_INIT;
    private boolean gameResult = BRIDGE_GAME_RESULT_INIT;

    public void countGameRound() {
        round++;
    }

    public void initGameRound() {
        round = BRIDGE_GAME_ROUND_INIT;
    }

    public int getGameRound() {
        return round;
    }

    public void lose() {
        this.gameResult = false;
    }

    public void win() {
        this.gameResult = true;
    }

    public boolean isWon() {
        return gameResult;
    }

    public void countTotalGameAttempts() {
        totalGameAttempts++;
    }

    public int getTotalGameAttempts() {
        return totalGameAttempts;
    }
}
