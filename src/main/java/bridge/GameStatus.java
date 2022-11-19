package bridge;

public class GameStatus {

    private int retryCount;
    private boolean gameWon;

    public GameStatus() {
        retryCount = 0;
        gameWon = false;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public String isGameWon() {
        if (gameWon) {
            return "성공";
        }
        return "실패";
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }
}
