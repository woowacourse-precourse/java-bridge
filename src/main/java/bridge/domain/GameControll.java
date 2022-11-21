package bridge.model;

public class GameControll {

    public GameControll() {
    }

    private int idx;
    private int cnt = 0;
    private boolean gamePowerWhether;
    private boolean gameSucessWheter = false;

    public void plusIdx() {
        idx += 1;
    }

    public void plusCnt() {
        cnt += 1;
    }

    public void turnoffGamePower() {
        gamePowerWhether = false;
    }

    public void sucessGame() {
        gameSucessWheter = true;
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

    public boolean getGameSucess() {
        return gameSucessWheter;
    }

}
