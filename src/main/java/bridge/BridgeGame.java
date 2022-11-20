package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Player;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private Player player;
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private int gameStatus;

    public BridgeGame() {

    }

    public BridgeGame(BridgeSize size, Player player) {
        bridge = new Bridge(bridgeMaker.makeBridge(size.getBridgeSize()));
        this.player = player;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        player.move(moveCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public Player getPlayer() {
        return player;
    }

    public Bridge getBridge() {
        return bridge;
    }
}
