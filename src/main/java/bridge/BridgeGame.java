package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private BridgeMaker bridgeMaker;
    private int currentIndex;

    public BridgeGame(int bridgeLength) {
        this.bridge = bridgeMaker.makeBridge(bridgeLength);
        currentIndex = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * 사용자의 입력을 인자로 받는다. 다리의 현재 위치에서 건널 수 있는 곳과 입력이 일치하면 한 칸 나아가고 true 반환, 일치하지 않으면 false 반환
     */
    public boolean move(String moveInput) {
        if (bridge.get(currentIndex).equals(moveInput)) {
            currentIndex++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
