package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final BridgePlayer player;
    private final BridgeMap bridgeMap;
    private boolean isPlayerAlive;

    public BridgeGame(Bridge bridge, BridgePlayer player){
        this.bridge = bridge;
        this.player = player;
        this.bridgeMap = new BridgeMap(bridge);
        this.isPlayerAlive = true;
    }

    public boolean move(String route) {
        player.goFront();
        isPlayerAlive = bridge.isMoveAble(player.getCurrentBridgePosition(), route);
        bridgeMap.updateCurrentMap(player.getCurrentBridgePosition(), isPlayerAlive);
        return isPlayerAlive;
    }

    public void retry() {
        player.increaseAttemptCount();
        player.initializePlayerPosition();
        changePlayerAliveState();
        bridgeMap.initializeCurrentMap();
    }

    private void changePlayerAliveState(){
        isPlayerAlive = !isPlayerAlive;
    }

    public BridgeMap getBridgeMap(){
        return this.bridgeMap;
    }

    public int bridgeSize(){
        return this.bridge.getBridgeSize();
    }

    public boolean isCompletedGame(){
        return (bridge.getBridgeSize() == player.getCurrentBridgePosition()+1) && isPlayerAlive;
    }

    public int getPlayerAttemptCount(){
        return player.getGameAttemptCount();
    }
}
