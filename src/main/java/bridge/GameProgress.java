package bridge;

import bridge.enums.GameCommand;
import bridge.enums.GameOver;
import bridge.enums.GameResult;

public class GameProgress {
    GameOver gameOver = GameOver.YET;
    GameResult gameResult = GameResult.UNDETERMINED;
    GameCommand gameCommand;
    int trial = 1;

    public GameOver getGameOver() {
        return gameOver;
    }

    public GameCommand getGameCommand() {
        return gameCommand;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public int getTrial() {
        return trial;
    }
}
