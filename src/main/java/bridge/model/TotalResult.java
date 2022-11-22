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

    public boolean loseGame() {
        return playerMap.isFailure();
    }

    public boolean winGame() {
        List<String> bridge = bridgeGame.getBridge();
        BridgeMapMaker bridgeMapMaker = new BridgeMapMaker(bridge);
        PlayerMap successBridgeMap = bridgeMapMaker.getSuccessBridgeMap();

        return playerMap.equals(successBridgeMap);
    }

    public int getTryCnt() {
        return bridgeGame.getTryCnt();
    }

    @Override
    public String toString() {
        return String.format("< TotalResult win=%b tryCnt=%d >", win(), tryCnt);
    }
}
