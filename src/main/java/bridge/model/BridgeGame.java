package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String CORRECT = "O";
    private final String INCORRECT = "X";

    private List<Bridge> input = new ArrayList<>();
    private List<String> bridge;
    private int retry = 1;

    public BridgeGame() {
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getRetry() {
        return retry;
    }

    public int getIndex() {
        return input.size() - 1;
    }

    public List<Bridge> getInput() {
        return input;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String position) {
        input.add(new Bridge(position, result(position)));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        retry += 1;
        input.remove(getIndex());
    }

    public boolean isAnswer() {
        return input.get(getIndex()).getResult().equals(CORRECT);
    }

    public String result(String position) {
        if (bridge.get(getIndex() + 1).equals(position)) {
            return CORRECT;
        }
        return INCORRECT;
    }

    public boolean isEnd() {
        return bridge.size() == input.size();
    }
}
