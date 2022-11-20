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
     *
     * @param bridge
     * @return if 이동가능, 이동하는 칸('U' or 'D')
     * else, null
     */
    public String move(List<String> bridge) {
        LifeGuard lifeGuard = new LifeGuard();
        String moving = inputView.readMoving();
        String next_bridge = bridge.get(current_position++);

        if (lifeGuard.checkSafety(moving, next_bridge)) {
            return moving;
        }

        return null;
    }

    /**
     * 유저가 다리를 건넜는지 체크한다.
     * @param userRoute
     * @param bridge
     * @return
     */
    public boolean checkCrossingBridge(List<String> userRoute, List<String> bridge) {
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public boolean gameover() {

        return true;
    }

    public boolean gameClear(int size, int bridgeSize) {
        return true;
    }
}
