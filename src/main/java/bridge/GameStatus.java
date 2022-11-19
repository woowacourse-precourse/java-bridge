package bridge;

public class GameStatus {

    private int tryCount;
    private boolean gameWon;

    public GameStatus() {
        tryCount = 1;
        gameWon = false;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
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
