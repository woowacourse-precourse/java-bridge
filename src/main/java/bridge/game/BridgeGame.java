package bridge.game;

import bridge.Bridge;
import bridge.BridgeValue;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RETRY_GAME = "R";
    private static final String QUIT_GAME = "Q";

    private final Bridge bridge;

    public BridgeGame(List<String> space) {
        this.bridge = new Bridge(space);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<Bridge> move(String direction, List<Bridge> bridges) {
        if (direction.equals(BridgeValue.LOWER_BRIDGE.getDirection())) {
            return moveLower(bridges);
        }
        if (direction.equals(BridgeValue.UPPER_BRIDGE.getDirection())) {
            return moveUpper(bridges);
        }
        return null;
    }

    private List<Bridge> moveLower(List<Bridge> bridges) {
        return bridge.drawSuccessLowerBridge(bridges);
    }

    private List<Bridge> moveUpper(List<Bridge> bridges) {
        return bridge.drawSuccessUpperBridge(bridges);
    }

    public List<Bridge> stop(String direction, List<Bridge> bridges) {
        if (direction.equals(BridgeValue.LOWER_BRIDGE.getDirection())) {
            return stopLower(bridges);
        }
        if (direction.equals(BridgeValue.UPPER_BRIDGE.getDirection())) {
            return stopUpper(bridges);
        }
        return null;
    }

    private List<Bridge> stopLower(List<Bridge> bridges) {
        return bridge.drawFailLowerBridge(bridges);
    }

    private List<Bridge> stopUpper(List<Bridge> bridges) {
        return bridge.drawFailUpperBridge(bridges);
    }

    // TODO: retry command 검증
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals(RETRY_GAME)) {
            return true;
        }
        return false;
    }
}