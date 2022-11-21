package bridge.domain;

import java.util.List;

public class Result {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private final String bridgeMap;
    private final int gameCount;
    private String winning;

    public Result(String bridgeMap, boolean status, int gameCount) {
        this.bridgeMap =bridgeMap;
        this.gameCount = gameCount;
        currentGameStatus(status);
    }

    private void currentGameStatus(boolean status) {
        if (status) {
            this.winning = SUCCESS;
        }
        if (!status) {
            this.winning = FAIL;
        }
    }

    public String getBridgeMap() {
        return bridgeMap;
    }

    public String getWinning() {
        return winning;
    }

    public int getGameCount() {
        return gameCount;
    }

    public static boolean checkWinning(int mapCoordinate, List<String> bridge) {
        return bridge.size() == mapCoordinate;
    }
}
