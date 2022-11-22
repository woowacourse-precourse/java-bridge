package bridge;

import bridge.enums.GameCommand;
import bridge.enums.GameOver;
import bridge.enums.GameResult;

public class GameProgress {
    private GameOver gameOver = GameOver.YET;
    private GameResult gameResult = GameResult.UNDETERMINED;
    private GameCommand gameCommand;
    private int trial = 1;

    public GameOver getGameOver() {
        return this.gameOver;
    }

    public GameCommand getGameCommand() {
        return this.gameCommand;
    }

    public GameResult getGameResult() {
        return this.gameResult;
    }

    public int getTrial() {
        return trial;
    }

    public void plusTrial() {
        this.trial+=1;
    }

    public void resetGameOver() { this.gameOver = GameOver.YET;}

    public void gameOver() { this.gameOver = GameOver.OVER;}

    public void retrialGameCommand() { this.gameCommand = GameCommand.RETRIAL;}

    public void setGameCommand(GameCommand gameCommand) {this.gameCommand = gameCommand;}

    public void resetGameResult() { this.gameResult = GameResult.UNDETERMINED;}

    public void gameFailed() {this.gameResult = GameResult.FAILED;}

    public void gameSuccess() {this.gameResult = GameResult.SUCCESS;}
}
