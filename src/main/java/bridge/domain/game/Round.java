package bridge.domain.game;

public class Round {

    private static final int STARTING_POINT = 1;
    private final int gameRound;

    public Round(int gameRound) {
        validateNumber(gameRound);
        this.gameRound = gameRound;
    }

    private void validateNumber(int number) {
        if (isLessThanRange(number)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 게임 라운드 입니다.");
        }
    }

    private boolean isLessThanRange(int number) {
        return number < STARTING_POINT;
    }

    public int getGameRound() {
        return gameRound;
    }
}