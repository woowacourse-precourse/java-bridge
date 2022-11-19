package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int tryNumber;
    private List<String> preStatus = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String whereMoving) {
        this.preStatus.add(whereMoving);
    }

    public void back(int step) {
        this.preStatus.remove(step);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.tryNumber ++;
    }

    public void start() {
        this.tryNumber = 1;
    }

    public void end() {
        this.tryNumber = 0;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public List<String> getPreStatus() {
        return this.preStatus;
    }


}
