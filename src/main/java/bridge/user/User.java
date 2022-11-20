package bridge.user;

/**
 * 사용자 상태 관리
 */
public class User {

    private boolean isPlayingGame;
    private boolean isGameSucceed;
    private int numberOfTrials;

    public User(boolean isPlayingGame, boolean isGameSucceed, int numberOfTrials) {
        this.isPlayingGame = isPlayingGame;
        this.isGameSucceed = isGameSucceed;
        this.numberOfTrials = numberOfTrials;
    }

    public void setNotPlayingGame() {
        isPlayingGame = false;
    }

    public boolean isPlayingGame() {
        return isPlayingGame;
    }

    public boolean isGameSucceed() {
        return isGameSucceed;
    }

    public void setGameSucceed() {
        isGameSucceed = true;
    }

    public void increaseNumberOfTrials() {
        numberOfTrials += 1;
    }

}
