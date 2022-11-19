package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<String> upBlocks;
    private List<String> downBlocks;
    private GameStatus gameOver;
    private int totalTryNumber;

    public Result() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
        gameOver = GameStatus.PLAYING;
    }

    public void init() {
        upBlocks = new ArrayList<>();
        downBlocks = new ArrayList<>();
        gameOver = GameStatus.PLAYING;
        totalTryNumber = 0;
    }

    public void addBlocks(BlockExpression blockExpression) {
        this.upBlocks.add(blockExpression.getUpBlock());
        this.downBlocks.add(blockExpression.getDownBlock());
    }

    public void success() {
        this.gameOver = GameStatus.SUCCESS;
    }

    public void fail() {
        this.gameOver = GameStatus.FAIL;
    }

    public boolean gameOver() {
        return !gameOver.equals(GameStatus.PLAYING);
    }

    public boolean isFail() {
        return gameOver == GameStatus.FAIL;
    }

    public void tryMove() {
        this.totalTryNumber += 1;
    }

    public GameStatus getGameOver() {
        return gameOver;
    }

    public int getTotalTryNumber() {
        return totalTryNumber;
    }

    public List<String> getUpBlocks() {
        return this.upBlocks;
    }

    public List<String> getDownBlocks() {
        return this.downBlocks;
    }

    public enum GameStatus {
        SUCCESS("성공"),
        FAIL("실패"),
        PLAYING("진행중");

        private String name;

        GameStatus() {
        }

        GameStatus(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
