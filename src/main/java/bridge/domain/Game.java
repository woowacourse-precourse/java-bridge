package bridge.domain;

public class Game {
    private boolean isGameDone;
    private boolean isWinGame;

    private int gameCount;

    public Game() {
        this.isGameDone = false;
        this.isWinGame = false;
        this.gameCount = 1;
    }

    public boolean isGameDone() {
        return isGameDone;
    }

    private void setGameDone(boolean gameDone) {
        isGameDone = gameDone;
    }

    public boolean isWinGame() {
        return isWinGame;
    }



}
