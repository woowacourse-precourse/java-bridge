package bridge;

public class GameStatus {
    private static final int DEFAULT_POSITION = 0;
    private final int bridgeSize;
    private final BridgeMatcher bridgeMatcher;
    private final GameResult gameResult = new GameResult();

    private int pivot = 0;

    public GameStatus(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        bridgeMatcher = new BridgeMatcher(bridgeSize);
    }

    public GameResult getResult() {
        return gameResult;
    }

    public void retry() {
        bridgeMatcher.init();
        gameResult.retry();
        pivot = DEFAULT_POSITION;
    }

    public boolean cross(Command command) {
        if(bridgeMatcher.match(command)) {
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
