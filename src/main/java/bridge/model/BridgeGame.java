package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> up = new ArrayList<>();
    private List<String> down = new ArrayList<>();
    private int currentCount = 0;
    private boolean gameContinue = true;
    private int gameCount = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move, List<String> bridge) {
        if (move.contentEquals("U")) {
            moveUp(move, bridge);
            return;
        }
        moveDown(move, bridge);
    }

    public void moveUp(String move, List<String> bridge) {
        up.add(moveMatch(move, bridge));
        down.add("   ");
    }

    public void moveDown(String move, List<String> bridge) {
        up.add("   ");
        down.add(moveMatch(move, bridge));
    }

    public String moveMatch(String move, List<String> bridge) {
        if (bridge.get(currentCount).contentEquals(move)) {
            currentCount++;
            return " O ";
        }
        currentCount = bridge.size();
        gameContinue = false;
        return " X ";
    }

    public List<String> getUp() {
        return up;
    }

    public List<String> getDown() {
        return down;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public boolean isGameContinue() {
        return gameContinue;
    }

    public int getGameCount() {
        return gameCount;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currentCount = 0;
        gameContinue = true;
        up = new ArrayList<>();
        down = new ArrayList<>();
        gameCount++;
    }
}
