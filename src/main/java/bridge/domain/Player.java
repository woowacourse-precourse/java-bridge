package bridge.domain;

import java.util.List;

public class Player {
    private final PlayerStatus playerStatus = new PlayerStatus();
    private boolean movingResult;
    private int location;
    private int tryCount = 1;

    public Player() {
        setDefault();
    }

    public void setDefault() {
        location = 0;
        playerStatus.setDefault();
    }

    public boolean isMovableBy(String playerMoving, List<String> bridge) {
        String bridgeMoving = bridge.get(location);
        return playerMoving.equals(bridgeMoving);
    }

    public void updatePlayerStatus(boolean isMovable, String playerMoving) {
        this.movingResult = isMovable;
        playerStatus.update(isMovable, playerMoving);
        location++;
    }

    public void retry() {
        setDefault();
        tryCount++;
    }

    //플레이어의 게임 결과
    public boolean isArrived(int bridgeSize) {
        return movingResult && location == bridgeSize;
    }

    public boolean isFailed() {
        return !movingResult;
    }


    //플레이어 필드 getter
    public String getPlayerStatus() {
        return playerStatus.toString();
    }

    public int getTryCount() {
        return tryCount;
    }

}
