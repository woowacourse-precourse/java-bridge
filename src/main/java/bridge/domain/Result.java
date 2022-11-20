package bridge.domain;

public class Result {
    private BridgeStatus bridgeStatus;
    private GameStatus gameOver;

    public Result() {
        bridgeStatus = new BridgeStatus();
        gameOver = GameStatus.PLAYING;
    }

    public void init() {
        gameOver = GameStatus.PLAYING;
        bridgeStatus = new BridgeStatus();
    }

    public void addBlocks(BlockExpression blockExpression) {
        bridgeStatus.addStatus(blockExpression);
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

    public GameStatus getGameOver() {
        return gameOver;
    }

    public BridgeStatus getBridgeStatus() {
        return this.bridgeStatus;
    }

    public enum GameStatus {
        SUCCESS("성공"),
        FAIL("실패"),
        PLAYING("진행중");

        private final String name;

        GameStatus(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
