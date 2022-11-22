package bridge;

public class GameRecorder {
    private static final int DEFAULT_POSITION = 0;
    private final int bridgeSize;
    private final BridgeMatcher bridgeMatcher;
    private final GameResult gameResult = new GameResult();

    private int pivot = 0;

    public GameRecorder(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        bridgeMatcher = new BridgeMatcher(bridgeSize);
    }

    public GameResult getResult() {
        return gameResult;
    }

    public void start() {
        bridgeMatcher.init();
        gameResult.attempt();
        pivot = DEFAULT_POSITION;
    }

    public boolean recordMove(Command command) {
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
