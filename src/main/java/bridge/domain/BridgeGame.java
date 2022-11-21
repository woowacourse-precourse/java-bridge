package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private List<Record> history;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.history = new ArrayList<>(bridge.size());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(BridgeCell cell) {

        if (bridge.canMove(cell, history.size())) {
            moveForward(cell);
            return true;
        }

        moveFail(cell);
        return false;
    }

    private void moveForward(BridgeCell cell) {
        history.add(new Record(cell, true));
    }

    private void moveFail(BridgeCell cell) {
        history.add(new Record(cell, false));
    }

    public String getMap() {
        return MapGenerator.generateMap(history);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        history.remove(history.size() - 1);
        return true;
    }

    public boolean end() {
        return true;
    }

    public boolean isEnd() {
        return history.size() == bridge.size();
    }

    public String getResult() {
        return ResultGenerator.generateResult(isEnd());
    }
}
