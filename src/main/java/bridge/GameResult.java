package bridge;

public class GameResult {
    private int tryCount = 0;
    private boolean isGameClear = false;
    private final BridgeMap bridgeMap = new BridgeMap();

    public void attempt() {
        countUp();
        bridgeMap.reset();
    }

    public void gameClear() {
        isGameClear = true;
    }

    public boolean getGameClear() {
        return isGameClear;
    }

    public void addMapSuccess(Command command) {
        bridgeMap.moveSuccess(command);
    }

    public void addMapFail(Command command) {
        bridgeMap.moveFail(command);
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void countUp() {
        tryCount++;
    }
}
