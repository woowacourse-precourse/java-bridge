package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final int tryCnt;
    private final BridgeMap successMap;
    private final BridgeMap failureMap;

    public BridgeGame(List<String> bridge, int tryCnt) {
        this.bridge = bridge;
        this.tryCnt = tryCnt;

        BridgeMapMaker bridgeMapMaker = new BridgeMapMaker(bridge);
        this.successMap = bridgeMapMaker.getSuccessBridgeMap();
        this.failureMap = bridgeMapMaker.getFailureBridgeMap();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public RouteMap move(String movingSide, int distance) {
        if (movingSuccess(movingSide, distance)) {
            return getSuccessRouteAt(distance);
        }

        return getFailureRouteAt(distance);
    }

    private boolean movingSuccess(String movingSide, int distance) {
        String bridgeSide = bridge.get(distance - 1);
        return movingSide.equals(bridgeSide);
    }

    private RouteMap getSuccessRouteAt(int distance) {
        return successMap.getRouteAt(distance);
    }

    private RouteMap getFailureRouteAt(int distance) {
        RouteMap successRoute = successMap.getRouteAt(distance - 1);
        RouteMap failureStatus = failureMap.getStatusAt(distance);

        return successRoute.join(failureStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
