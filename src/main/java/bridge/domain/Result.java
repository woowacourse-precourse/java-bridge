package bridge.domain;

public class Result {
    private final BridgeMap bridgeMap;
    private final String successWhether;
    private final int gameCount;

    public Result(BridgeMap bridgeMap, String successWhether, int gameCount) {
        this.bridgeMap = bridgeMap;
        this.successWhether = successWhether;
        this.gameCount = gameCount;
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    public String getSuccessWhether() {
        return successWhether;
    }

    public int getGameCount() {
        return gameCount;
    }
}
