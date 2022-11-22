package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final int tryCnt;

    public BridgeGame(List<String> bridge, int tryCnt) {
        this.bridge = bridge;
        this.tryCnt = tryCnt;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public TotalResult move(String movingSide, int distance) {
        PlayerMapMaker playerMapMaker = new PlayerMapMaker(bridge);
        PlayerMap resultMap = playerMapMaker.makeFailurePlayerMapTo(distance);

        if (movingSuccess(movingSide, distance)) {
            resultMap = playerMapMaker.makeSuccessPlayerMapTo(distance);
        }

        return new TotalResult(this, resultMap);
    }

    private boolean movingSuccess(String movingSide, int distance) {
        String bridgeSide = bridge.get(distance - 1);
        return movingSide.equals(bridgeSide);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGame retry() {
        return new BridgeGame(bridge, tryCnt + 1);
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public List<String> getBridge() {
        return bridge;
    }

    @Override
    public String toString() {
        return String.format("< BridgeGame bridge=%s round=%d >", bridge, tryCnt);
    }
}
