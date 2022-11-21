package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int tryCount;
    private int curLevel;

    public BridgeGame(int tryCount, int curLevel, List<String> bridge) {
        this.tryCount = tryCount;
        this.curLevel = curLevel;
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * input : direction -> String
     * return : boolean (success or failure)
     */
    public boolean move(String direction) {
        curLevel += 1;
        System.out.println("curLevel = " + curLevel);
        return bridge.get(curLevel).equals(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        curLevel = -1;
        tryCount += 1;
    }

    public boolean checkGameEnded(boolean succeeded) {
        return curLevel == bridge.size()-1 || !succeeded;
    }

    public boolean gameSucceeded() {
        return curLevel == bridge.size()-1;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getCurLevel() {
        return curLevel;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
