package bridge;

public class GameStatus {
    private static final int DEFAULT_POSITION = 0;
    private BridgeGame bridgeGame;

    private GameResult gameResult = new GameResult();
    private final int bridgeSize;
    private int pivot = 0;

    public GameStatus(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public GameResult getResult() {
        return gameResult;
    }

    public void retry() {
        bridgeGame.retry();
        gameResult.retry();
        pivot = DEFAULT_POSITION;
    }

    public boolean cross(Command command) {
        if(bridgeGame.move(command)) {
            gameResult.addMapSuccess(command);
            pivotUp();
            return true;
        }
        gameResult.addMapFail(command);
        return false;
    }

    private void pivotUp() {
        pivot++;
        checkClear();
    }

    private void checkClear() {
        if(pivot == bridgeSize) {
            gameResult.gameClear();
        }
    }
}
