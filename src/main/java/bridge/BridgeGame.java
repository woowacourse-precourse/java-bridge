package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private InputView inputView = new InputView();

    /**
     * 현재 user가 bridge에 위치하고있는 곳(bridge index)
     */
    private int current_position = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @return 다리 다음 구역으로 이동가능 여부
     */
    public boolean move(String moving, List<String> bridge) {
        String next_bridge = bridge.get(current_position++);

        return moving == next_bridge;
    }

    /**
     * 유저가 다리를 건넜는지 체크한다.
     */
    public boolean checkCrossingBridge(List<String> bridge) {
        return current_position == bridge.size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        current_position = 0;
    }
}
