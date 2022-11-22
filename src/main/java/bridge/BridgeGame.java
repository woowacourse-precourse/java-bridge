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
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public boolean move(String moving) {
        int index = userRoute.size();
        userRoute.add(moving);
        if (bridge.get(index).equals(moving)) {
            return true;
        }
        return false;
    }

    /**
     * 게임 초기화
     */
    public void init(List<String> bridge) {
        this.bridge = bridge;
        this.userRoute = new ArrayList<>();
        this.gameCount = 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        this.userRoute = new ArrayList<>();
        this.gameCount += 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserRoute() {
        return userRoute;
    }


    public int getGameCount() {
        return gameCount;
    }

}
