package bridge.domain.gameManagement;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.PlayerMove.PlayerMove;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int INITIAL_LOCATION = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(List<String> bridge, List<String> currentBridge) {
        int currentLocation = INITIAL_LOCATION;

        currentLocation = PlayerMove.moveOneStep(currentLocation, bridge, currentBridge);

        return currentLocation;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<String> constructBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int bridgeSize = bridgeMaker.takeBridgeSize();

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
