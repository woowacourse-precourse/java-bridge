package bridge.domain.game;

public class GamePlayer {
    private int position;
    private int trial;
    private boolean isFailGame;

    private GamePlayer(int position, int trial, boolean isFailGame) {
        this.position = position;
        this.trial = trial;
        this.isFailGame = isFailGame;
    }

    public static GamePlayer withDefaultValue() {
        return new GamePlayer(0, 1, false);
    }

    public void move() {
        this.position += 1;
    }

    public void failGame() {
        this.isFailGame = true;
    }

    public void retryGame() {
        this.trial += 1;
        this.position = 0;
        this.isFailGame = false;
    }

    public int getPosition() {
        return position;
    }

    public int getTrial() {
        return trial;
    }

    public boolean isFailGame() {
        return isFailGame;
    }

}
