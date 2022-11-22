package bridge.model;

import java.util.List;

public class TotalResult {

    private final BridgeGame bridgeGame;
    private final PlayerMap playerMap;

    public TotalResult(BridgeGame bridgeGame, PlayerMap playerMap) {
        this.bridgeGame = bridgeGame;
        this.playerMap = playerMap;
    }

    public PlayerMap getPlayerMap() {
        return playerMap;
    }

    public boolean win() {
        return !playerMap.isFailure();
    }

    public int getTryCnt() {
        return bridgeGame.getTryCnt();
    }

    @Override
    public String toString() {
        return String.format("< TotalResult win=%b tryCnt=%d >", win(), tryCnt);
    }
}
