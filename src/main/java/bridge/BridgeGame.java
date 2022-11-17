package bridge;

import java.util.ArrayList;
import java.util.List;

/** 인스턴스변수 추가 가능. 패키지 변경불가. 메서드 이름 변경불가. 인자와 반환타입은 추가 변경 가능.
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> myAnswerBridges = new ArrayList<>();
    private int attemptCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public void move(Bridge bridge) {
        if (isDroppedBridge(bridge)) {
            myAnswerBridges.add("X");
        }

        myAnswerBridges.add(bridge.getMyMovingPostion());
    }

    private static boolean isDroppedBridge(Bridge bridge) {
        return !bridge.isCorrectBridge();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.myAnswerBridges.clear();
        this.attemptCount = attemptCount + 1;
    }

    public List<String> getMyAnswerBridges() {
        return myAnswerBridges;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
