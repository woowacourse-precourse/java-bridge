package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private UsersRoute usersRoute;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.usersRoute = new UsersRoute();
    }

    public UsersRoute getUsersRoute() {
        return this.usersRoute;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        this.usersRoute.put(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.usersRoute = new UsersRoute();
    }

    public boolean isFail() {
        List<String> route = usersRoute.getRoute();
        return !route.get(route.size() - 1).equals(bridge.getBridge().get(route.size() - 1));
    }

    public boolean isSameLength() {
        return (usersRoute.getRoute().size() == bridge.getBridge().size());
    }
}
