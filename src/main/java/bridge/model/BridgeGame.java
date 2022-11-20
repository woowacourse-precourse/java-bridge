package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Moved move(String userMove,BridgeSpace bridgeSpace) {
        return bridgeSpace.checkMoving(userMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridge
     */
    public Bridge retry(Bridge bridge) {
        bridge.getBridgeSpaces().forEach(BridgeSpace::init);
        return bridge;
    }


    public boolean checkAllDone(Bridge bridge) {
        return bridge.getBridgeSpaces().get(bridge.getBridgeSpaces().size() -1).getMyMoved() == Moved.CAN;
    }


}
