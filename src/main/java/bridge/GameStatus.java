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

    public Boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public String getGameEndFlag() {
        if (gameWon) {
            return "성공";
        }
        return "실패";
    }
}
