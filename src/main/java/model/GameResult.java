package model;

import static model.ResultType.WIN;

public class GameResult {
    private ResultType result;

    public GameResult() {
        this.result = WIN;
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

    @Override
    public String toString() {
        return result.getMessage();
    }
}
