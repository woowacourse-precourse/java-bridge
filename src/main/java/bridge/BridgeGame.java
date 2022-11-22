package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private List<String> crossed;
    private int stage;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        stage = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, String input) {
        bridge.getCrossed().add(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean isCorrect(Bridge bridge) {
        List<String> footholds = bridge.getFootholds();
        List<String> crossed = bridge.getCrossed();
        int lastFootholdIndex = bridge.getCrossed().size() - 1;

        if (!crossed.get(lastFootholdIndex).equals(footholds.get(lastFootholdIndex))) {
            return false;
        }
        return true;
    }
}
