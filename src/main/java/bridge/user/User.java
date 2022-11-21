package bridge.user;

/**
 * 사용자 상태 관리
 */
public class User {

    private boolean isPlayingGame;
    private boolean isGameSucceed;
    private int numberOfMoves;
    private int numberOfGameTrials;

    public User(boolean isPlayingGame, boolean isGameSucceed, int numberOfGameTrials) {
        this.isPlayingGame = isPlayingGame;
        this.isGameSucceed = isGameSucceed;
        this.numberOfGameTrials = numberOfGameTrials;
    }

    // getter
    public boolean isPlayingGame() {
        return isPlayingGame;
    }

    public boolean isGameSucceed() {
        return isGameSucceed;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public int getNumberOfGameTrials() {
        return numberOfGameTrials;
    }

    // setter
    public void setNotPlayingGame() {
        isPlayingGame = false;
    }

    public void setGameSucceed() {
        isGameSucceed = true;
    }

    // method
    public void resetNumberOfMoves() {
        numberOfMoves = 0;
    }

    public void increaseNumberOfGameTrials() {
        numberOfGameTrials += 1;
    }

    public void increaseNumberOfMoves() {
        numberOfMoves += 1;
    }

}
