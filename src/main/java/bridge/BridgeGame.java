package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private List<String> current;
    private int attempt;

    public BridgeGame(Bridge bridge, List<String> current, int attempt) {
        this.bridge = bridge;
        this.current = current;
        this.attempt = attempt;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        current.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        current = new ArrayList<>();
        attempt += 1;
    }

    public boolean isEnd() {
        return bridge.isSizeEquals(current.size());
    }

    public boolean isStepSuccess() {
        int index = current.size() - 1;
        return bridge.isStepSuccess(current.get(index), index);
    }

    public boolean isSuccess() {
        return bridge.compareBridgeWith(current);
    }

    public int getAttempt() {
        return attempt;
    }

    public List<List<String>> analyzeResult() {
        Referee referee = new Referee(bridge, current);
        return referee.analyze();
    }

}
