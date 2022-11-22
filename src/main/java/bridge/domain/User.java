package bridge.domain;

import bridge.service.constant.GameStatus;

public class User {
    private int attemptCount;
    private int round;
    private GameStatus status;

    public User() {
        attemptCount = 1;
        round = 0;
        status = GameStatus.PLAYING;
    }

    public void playNextRound() {
        round++;
    }

    public void playSameRoundAgain() {
        round--;
        attemptCount++;
        status = GameStatus.PLAYING;
    }

    public void failRound() {
        status = GameStatus.FAIL;
    }

    public void clearGame() {
        status = GameStatus.SUCCESS;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getRound() {
        return round;
    }

    public GameStatus getStatus() {
        return status;
    }
}
