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
     * @param bridge
     */
    public boolean checkCrossingBridge(List<String> bridge) {
        return current_position == bridge.size();
    }

    /**
     * 게임 한 라운드가 끝난 뒤 game clear 체크 및 game retry를 한다.
     * @param bridge
     * @return 재시작 여부
     */
    public boolean gameover(List<String> bridge) {
        if(gameClear(bridge)) {
            return false;
        }

        if(inputView.readGameCommand()) {
            retry();
            return true;
        }

        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    private void retry() {
        current_position = 0;
    }

    private boolean gameClear(List<String> bridge) {
        return current_position == bridge.size();
    }
}
