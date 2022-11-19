package bridge;

public class GameStatus {

    private int tryCount;
    private boolean gameWon;
    private boolean gameEnd;

    public GameStatus() {
        tryCount = 1;
        gameWon = false;
        gameEnd = false;
    }



    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
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
