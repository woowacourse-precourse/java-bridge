package bridge.model;

import bridge.utils.BridgeDirection;
import bridge.utils.Mark;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> upRoute;
    private final List<String> downRoute;
    private int movingCount;
    private int gameCount;

    public BridgeGame() {
        upRoute = new LinkedList<>();
        downRoute = new LinkedList<>();
        gameCount = 1;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(Mark mark) {
        if (mark.getDirection().equals(BridgeDirection.UP.getDirection())) {
            return addUpRoute(mark);
        }
        return addDownRoute(mark);
    }

    private List<List<String>> addUpRoute(Mark mark) {
        upRoute.add(mark.getMark());
        downRoute.add(" ");
        return List.of(upRoute, downRoute);
    }

    private List<List<String>> addDownRoute(Mark mark) {
        downRoute.add(mark.getMark());
        upRoute.add(" ");
        return List.of(upRoute, downRoute);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        resetRoute();
        resetMovingCount();
        countGame();
    }

    private void resetRoute() {
        upRoute.clear();
        downRoute.clear();
    }

    private void resetMovingCount() {
        movingCount = 0;
    }

    private void countGame() {
        gameCount++;
    }

    public int countMoving() {
        return movingCount++;
    }
}
