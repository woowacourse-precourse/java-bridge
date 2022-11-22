package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int tryCount;
    private boolean aliveState;
    private List<Tile> movingPathLog;

    public Player() {
        this.tryCount = 1;
        this.aliveState = true;
        initPosition();
    }

    /**
     * 한칸 앞으로 이동
     *
     * @param targetTile 이동할 칸의 방향
     * @return 이동한 후 위치 index
     */
    public int moveForward(Tile targetTile) {
        movingPathLog.add(targetTile);
        return movingPathLog.size() - 1;
    }

    /**
     * player의 상태를 사망상태로 전환
     */
    public void die() {
        this.aliveState = false;
    }

    /**
     * player가 사망상태라면 부활, 아니라면 아무행동 안함
     * 부활시 위치초기화, 시도횟수 1 증가
     */
    public void resurrect() {
        if (!isAlive()) {
            initPosition();
            tryCount++;
            this.aliveState = true;
        }
    }

    private void initPosition() {
        movingPathLog = new ArrayList<>();
    }

    /**
     * player가 위치가 맞는지 확인
     *
     * @param position 확인할 사용자의 위치 index (첫칸이 0부터 시작)
     * @return 현 위치가 맞으면 true, 아니면 false
     */
    public boolean isCurrentPosition(int position) {
        return getCurrentPositionIndex() == position;
    }

    /**
     * player가 이미 지난 칸인가 확인
     *
     * @param position 확인할 사용자의 위치 index (첫칸이 0부터 시작)
     * @return 지나간 길이면 true, 아니면 false
     */
    public boolean isPassedPosition(int position) {
        return getCurrentPositionIndex() >= position;
    }

    private int getCurrentPositionIndex() {
        return movingPathLog.size() - 1;
    }

    /**
     * player의 생존 상태 확인
     *
     * @return 살아있다면 ture, 아니면 false
     */
    public boolean isAlive() {
        return aliveState;
    }

    /**
     * 사용자가 지나온 다리 칸 확인
     *
     * @param index 확인할 사용자의 위치 index (첫칸이 0부터 시작)
     * @return 해당 칸의 Tile enum
     */
    public Tile getPassedTileLogOf(int index) {
        return movingPathLog.get(index);
    }

    /**
     * 총 시도 횟수 반환
     *
     * @return 총 시도 횟수
     */
    public int getTryCount() {
        return this.tryCount;
    }
}
