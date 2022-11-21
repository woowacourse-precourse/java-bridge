package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeStatus;
import bridge.domain.Player;
import bridge.domain.PlayerStatus;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final BridgeStatus bridgeStatus;
    private final Player player = new Player();

    public BridgeGame(int bridgeSize) {
        bridge = new Bridge(makeBridge(bridgeSize));
        bridgeStatus = new BridgeStatus();
        player.init();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeStatus move(String direction) {
        int position = player.getNextPosition();
        if(bridge.isCrossable(position, direction)) {
            bridgeStatus.update(direction, player.move());
            return bridgeStatus;
        }
        bridgeStatus.update(direction, player.fail());
        return bridgeStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    public List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = getBridgeMaker();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public BridgeMaker getBridgeMaker() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public boolean isNotFinished() {
        return player.getStatus() != PlayerStatus.SUCCESS;
    }
}
