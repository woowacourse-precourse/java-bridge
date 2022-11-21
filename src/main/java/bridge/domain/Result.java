package bridge.domain;

import java.util.List;

public class Result {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private final BridgeMap bridgeMap;
    private final int blockCount;
    private final int gameCount;
    private String winning;

    public Result(BridgeGame bridgeGame) {
        this.bridgeMap = bridgeGame.getBridgeMap();
        this.blockCount = bridgeGame.getMapCoordinate();
        this.gameCount = bridgeGame.getGameCount().count();
        currentGameStatus(bridgeGame.isStatus());
    }

    private void currentGameStatus(boolean status) {
        if (status) {
            this.winning = SUCCESS;
        }
        if (!status) {
            this.winning = FAIL;
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

    public int getBlockCount() {
        return blockCount;
    }

    public static boolean checkWinning(int mapCoordinate, List<String> bridge) {
        return bridge.size() == mapCoordinate;
    }
}
