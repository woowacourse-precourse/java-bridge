package bridge.domain;

import bridge.command.MarkCommand;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> result;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        result = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String square) {
        if(bridge.get(result.size()).equals(square)) {
            result.add(MarkCommand.Possible.get());
            return;
        }

        result.add(MarkCommand.Impossible.get());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.clear();
    }

    public int getBridgeSize() {
        return bridge.size();
    }
    public int getResultSize() {
        return result.size();
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(result);
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }
}
