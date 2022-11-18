package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<BridgeToken> bridgeTokens = new ArrayList<>();
    private final Bridge bridge;
    private int retryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = new Bridge(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Direction value) {
        if (tryForward(value)) {
            bridgeTokens.add(new BridgeToken(value, true));
            bridge.moveForward();
            return true;
        }
        bridgeTokens.add(new BridgeToken(value, false));
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(GameCommand gameCommand) {
        if (gameCommand.equals(GameCommand.RETRY)) {
            initGame();
            return true;
        }
        return false;
    }

    public boolean tryForward(Direction direction) {
        return bridge.isCurrentBridgeDirection(direction.getCommand());
    }

    private void initGame() {
        bridge.init();
        bridgeTokens.clear();
        retryCount++;
    }

    public boolean isEnd() {
        return bridge.isCross();
    }

    public List<BridgeToken> getBridgeTokens() {
        return bridgeTokens;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
