package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, String direction) {
        bridge.getMoveTrace().add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean isSurvive(Bridge bridge){
        List<String> moveTrace = bridge.getMoveTrace();
        List<String> bridgeSubShape = bridge.getBridgeShape().subList(0, moveTrace.size());
        return moveTrace.equals(bridgeSubShape);
    }

    public boolean isClearGame(Bridge bridge){
        int bridgeSize = bridge.getBridgeShape().size();
        int moveShapeSize = bridge.getMoveTrace().size();
        return isSurvive(bridge) && bridgeSize == moveShapeSize;
    }

    public void retry(Bridge bridge) {
        bridge.getMoveTrace().clear();
        bridge.increaseAttemptNumber();
    }
}
