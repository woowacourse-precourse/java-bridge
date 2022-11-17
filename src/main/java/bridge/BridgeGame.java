package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private int counter;
    private List<String> bridges;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String cmd) {
    }

    public void init() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.counter = 0;
    }

    public void setBridgeSize(int n) {
        this.bridges = bridgeMaker.makeBridge(n);
    }

    /**
     * 게임이 종료되었는 지 확인합니다.
     * @return 종료된 경우 true, 진행 중인 경우 false
     */
    public boolean isFinished() {
        return false;
    }

    /**
     * 게임이 오답 등의 사유로 비정상종료 되었는 지 확인합니다,
     * @return 비정상종료
     */
    public boolean aborted() {
        return false;
    }

    /**
     * 게임 최종 결과가 성공/실패로 끝났는 지 값을 돌려줍니다.
     * @return 성공시 true, 실패시 false
     */
    public boolean succeed() {
        return true;
    }

    public int getTries() {
        return this.counter;
    }
}
