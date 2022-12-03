package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge = new ArrayList<>();
    private List<String> userRoute = new ArrayList<>();
    private int gameCount;

    /**
     * 게임 초기화 하는 메서드
     *
     * @param bridge 다리
     */
    public void init(List<String> bridge) {
        this.bridge = bridge;
        this.userRoute = new ArrayList<>();
        this.gameCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param moving 사용자가 어떤 방향으로 이동할지
     */
    public void move(String moving) {
        userRoute.add(moving);
    }

    /**
     * 지금까지의 이동이 올바른 이동인지 확인하는 메서드
     *
     * @return 지금 까지의 이동이 이상 없을 경우 true, 이상 있을 경우 false
     */
    public boolean isCorrectMove() {
        return userRoute.equals(bridge.subList(0, userRoute.size()));
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        this.userRoute = new ArrayList<>();
        this.gameCount += 1;
    }

    /**
     * 다리를 조회하는 메서드
     *
     * @return 현재 게임의 다리 반환
     */
    public List<String> getBridge() {
        return bridge;
    }

    /**
     * 사용자의 이동 경로를 조회하는 메서드
     *
     * @return 사용자의 이동 경로 반환
     */
    public List<String> getUserRoute() {
        return userRoute;
    }


    /**
     * 몇 번째 도전인지 조회 하는 메서드
     *
     * @return 현재 도전 횟수 반환
     */
    public int getGameCount() {
        return gameCount;
    }

}
