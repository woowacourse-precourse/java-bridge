package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final Player player;
    private Bridge bridge;

    public BridgeGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.player = new Player();
    }

    public void create() {
        int size = player.inputBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void tryGame() {
        player.oneMoreTry();
    }

    public boolean move() {
        String nextLocation = player.inputMove();
        if (bridge.ableToMove(nextLocation, player.getCurrentIndex() + 1)) {
            player.move();
            return true;
        }
        return false;
    }

    public boolean isOnGoing() {
        if (player.getCurrentIndex() < bridge.getBridgeSize() - 1) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }



}
