package bridge;

import bridge.identifiers.Direction;
import bridge.paths.Bridge;
import bridge.paths.PlayerPath;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private PlayerPath playerPath;

    public BridgeGame() {}

    public void initComponents(BridgeNumberGenerator bridgeNumberGenerator, int bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeLength));
        playerPath = new PlayerPath();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        playerPath.saveDirection(direction);
        if(!bridge.canBeSteppedBy(playerPath))
            playerPath.die();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public PlayerPath getPlayerPath(){
        return playerPath;
    }
}
