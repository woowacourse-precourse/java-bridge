package bridge.domain;

public class GameStatus {

    public GameStatus() {
    }

    private int idx;
    private int cnt = 0;
    private boolean gamePowerWhether;
    private boolean gameSuccessWhether = false;

    public void plusIdx() {
        idx += 1;
    }

    public void plusCnt() {
        cnt += 1;
    }

    public void turnoffGamePower() {
        gamePowerWhether = false;
    }

    public void successGame() {
        gameSuccessWhether = true;
    }

    public void initialize() {
        idx = 0;
        gamePowerWhether = true;
    }

    public int getIdx() {
        return idx;
    }

    public int getCnt() {
        return cnt;
    }

    public boolean getGamePower() {
        return gamePowerWhether;
    }

    public boolean getGameSuccess() {
        return gameSuccessWhether;
    }

}
