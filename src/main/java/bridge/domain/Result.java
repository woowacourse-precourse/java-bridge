package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> upBlocks;
    private List<String> downBlocks;
    private GameOver gameOver;
    private int totalTryNumber;

    public Result() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
        gameOver = GameOver.PLAYING;
    }

    public void init() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
        gameOver = GameOver.PLAYING;
        totalTryNumber = 0;
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

    public boolean isFail() {
        return gameOver == GameOver.FAIL;
    }

    public void tryMove() {
        this.totalTryNumber += 1;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }

    public enum GameOver {
        SUCCESS("성공"),
        FAIL("실패"),
        PLAYING("진행중");

        private String name;

        GameOver() {
        }

        GameOver(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
