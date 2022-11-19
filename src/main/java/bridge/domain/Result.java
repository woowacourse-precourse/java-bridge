package bridge.domain;

public class Result {
    private final BridgeMap bridgeMap;
    private final int gameCount;
    private String winning;

    public Result(BridgeMap bridgeMap, boolean status, int gameCount) {
        this.bridgeMap = bridgeMap;
        this.gameCount = gameCount;
        if (status) {
            this.winning = "성공";
        }
        if (!status) {
            this.winning = "실패";
        }
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    public String getWinning() {
        return winning;
    }

    public int getGameCount() {
        return gameCount;
    }

    public static boolean checkWinning(int mapCoordinate, Bridge bridge) {
        return bridge.getBridge().size() == mapCoordinate;
    }
}
