package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<String> upBlocks;
    private final List<String> downBlocks;
    private GameOver gameOver = GameOver.PLAYING;

    public Result() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
    }

    public void addBlocks(BlockExpression blockExpression) {
        this.upBlocks.add(blockExpression.getUpBlock());
        this.downBlocks.add(blockExpression.getDownBlock());
    }

    public List<String> getUpBlocks() {
        return this.upBlocks;
    }

    public List<String> getDownBlocks() {
        return this.downBlocks;
    }

    public void success() {
        this.gameOver = GameOver.SUCCESS;
    }

    public void fail() {
        this.gameOver = GameOver.FAIL;
    }

    public boolean gameOver() {
        return !gameOver.equals(GameOver.PLAYING);
    }

    public enum GameOver {
        SUCCESS,
        FAIL,
        PLAYING;

        GameOver() {
        }
    }
}
