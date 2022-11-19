package bridge.domain;

import java.util.List;

public class Player {
    private int currentSpaceIndex;
    private boolean alive;

    public Player() {
        currentSpaceIndex = 0;
        alive = true;
    }

    public void move(List<String> bridge, String spaceToMove) {
        int nextSpace = currentSpaceIndex + 1;
        currentSpaceIndex += 1;
        if (!bridge.get(nextSpace).equals(spaceToMove)) { // 그 칸에 발판이 없다면. 이 부분을 다리 객체가 하게끔 하는게 좋을 듯..
            fallOff();
        }
    }

    private void fallOff() {
        alive = false;
    }

    public boolean isDead() {
        return !alive;
    }

    public boolean isArrived(List<String> bridge) {
        return currentSpaceIndex == bridge.size() - 1;
    }

    public void reVive() {
        currentSpaceIndex = 0;
        alive = true;
    }
}
