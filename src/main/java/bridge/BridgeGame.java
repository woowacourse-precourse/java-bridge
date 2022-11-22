package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private List<String> userSelect = new ArrayList<>();
    private int attempt = 1;

    public BridgeGame(BridgeNumberGenerator numberGenerator,int size) {
        this.bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int updown) {
        if (updown == 1)
            this.userSelect.add("U");
        else if (updown == 0)
            this.userSelect.add("D");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.userSelect = new ArrayList<>();
        this.attempt++;
    }

    public boolean isEnd() {
        if (this.bridge.size() <= this.userSelect.size())
            return true;

        if (isFailed())
            return true;

        return false;
    }

    public boolean isFailed() {
        for (int i = 0; i < this.userSelect.size(); i++) {
            if (!this.bridge.get(i).equals(this.userSelect.get(i)))
                return true;
        }

        return false;
    }

    public List<String> getMap() {
        return this.bridge;
    }

    public List<String> getUserSelect() {
        return this.userSelect;
    }

    public int getTryCount() {
        return this.attempt;
    }
}
