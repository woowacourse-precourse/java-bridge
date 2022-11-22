package bridge.domain;


import bridge.constant.command.Command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<String> selections;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        selections = new ArrayList<>();
    }

    public List<String> getBridge() {
        List<String> clone = new ArrayList<>(bridge);
        return clone;
    }

    public List<String> getSelections() {
        List<String> clone = new ArrayList<>(selections);
        return clone;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getSelectionsSize() {
        return selections.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        if (bridge.get(selections.size()).equals(command)) {
            selections.add(Command.POSSIBLE.getCommand());
            return;
        }

        selections.add(Command.IMPOSSIBLE.getCommand());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
