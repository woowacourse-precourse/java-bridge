package bridge.domain;

import java.util.List;

public class Player {
    private int currentSpaceIndex;
    private boolean alive;

    public Player() {
        currentSpaceIndex = 0;
        alive = true;
    }

    public void move(Bridge bridge, String spaceToMove) {
        if (isDead()) {
            throw new IllegalStateException("[ERROR] 유효하지 않은 상태에서 move가 호출됐습니다");
        }
        int nextSpaceIndex = currentSpaceIndex + 1;
        currentSpaceIndex += 1;
        if (bridge.isBroken(nextSpaceIndex, spaceToMove)) { // 그 칸에 발판이 없다면. 이 부분을 다리 객체가 하게끔 하는게 좋을 듯..
            fallOff();
        }
    }

    private void fallOff() {
        alive = false;
    }

    public boolean isDead() {
        return !alive;
    }

    public boolean isArrived(Bridge bridge) {
        return currentSpaceIndex == bridge.size();
    }

    public void reVive() {
        currentSpaceIndex = 0;
        alive = true;
    }
}
