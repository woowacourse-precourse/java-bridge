package bridge.game;

import bridge.config.GameStatus;
import bridge.config.RunStatus;

import static bridge.config.GameStatus.*;
import static bridge.config.RunStatus.*;

public class Game {

    private int count;
    private RunStatus runStatus;
    private GameStatus gameStatus;

    public Game() {
        count = 1;
        runStatus = ON;
        gameStatus = FAIL;
    }

    public void addCount() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public RunStatus getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String result) {
        this.runStatus = runStatus.getStatus(result);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
