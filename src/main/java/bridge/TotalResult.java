package bridge;

public class TotalResult {
    private final PlayerMap playerMap;
    private final int tryCnt;

    public TotalResult(PlayerMap playerMap, int tryCnt) {
        this.playerMap = playerMap;
        this.tryCnt = tryCnt;
    }

    public PlayerMap getPlayerMap() {
        return playerMap;
    }

    public boolean win() {
        return !playerMap.isFailure();
    }

    public int getTryCnt() {
        return tryCnt;
    }
}
