package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private final List<String> bridge;
    private int trialCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.trialCount=0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String playerChoice) {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public void retry() {
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isGameEnd(List<String> playerBride) {
        return bridge.equals(playerBride);
    }

    public boolean isMovable(List<String> strings, int position) {
        return bridge.get(position).equals(strings.get(position));
    }

    public void addTrialCount() {
        this.trialCount++;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
