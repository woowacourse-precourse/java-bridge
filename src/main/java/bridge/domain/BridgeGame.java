package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private User user;

    public BridgeGame(Bridge bridge, User user) {
        this.bridge = bridge;
        this.user = user;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Integer index, String way) {
        if(bridge.canGo(index, way)){
            user.move(way);
            return true;
        }

        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String decision) {
        boolean gameRetry = Retry.getValue(decision);
        if (gameRetry) {
            user.resetPosition();
        }

        return gameRetry;
    }

    public List<String> getMap() {
        return user.getPosition();
    }

    public Integer getRetry(){
        return user.getRetry();
    }
}
