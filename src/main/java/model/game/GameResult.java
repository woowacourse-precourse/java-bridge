package model.game;

import static model.game.ResultType.WIN;

public class GameResult {
    private ResultType result;

    public GameResult() {
        this.result = WIN;
    }

    public ResultType getResult() {
        return result;
    }

    public boolean isRun() {
        return this.result.isRun();
    }

    public void update(boolean run) {
        this.result = ResultType.getByBoolean(run);
    }

    public void reset() {
        this.result = WIN;
    }
}
