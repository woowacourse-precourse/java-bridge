package bridge.controller;

import bridge.model.Player;
import bridge.model.BridgeMap;

import java.util.List;

public class BridgeGame {

    private Player player;
    private BridgeMap bridgeMap;

    public BridgeGame(List<String> bridge)
    {
        player = new Player(bridge);
        bridgeMap = new BridgeMap();
    }

    public boolean move(String nextMove) {
        boolean moveFlag = player.move(nextMove);
        bridgeMap.extendMap(nextMove,moveFlag);
        return moveFlag;
    }

    public void retry() {
        bridgeMap.restart();
        player.restart();
    }

    public boolean isFinish()
    {
        return player.isFinish();
    }
    public boolean isNotFinish() {
        return !player.isFinish();
    }

    public String getBridgeMap()
    {
        return bridgeMap.toString();
    }

    @Override
    public String toString()
    {
        return String.join("\n",bridgeMap.toString(),player.toString());
    }
}
