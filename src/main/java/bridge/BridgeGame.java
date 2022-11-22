package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;  // 랜덤하게 생성된 생성된 bridge
    private List<List<String>> bridgeFormat = new ArrayList<>();    // 사용자의 이동 결과에 따른 bridge의 현재 상황이 저장된 리스트
    private int tryCount = 0;   // 게임의 시도 횟수를 저장하는 변수
    private boolean keepGoing;  // 게임의 진행 여부를 결정하는 변수

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tryCount++;
        this.keepGoing = true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
