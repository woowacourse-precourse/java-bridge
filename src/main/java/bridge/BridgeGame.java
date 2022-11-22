package bridge;

import bridge.enums.Retry;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    List<String> bridges;

    BridgeGame(int bridgeSize) {
        bridges = bridgeMaker.makeBridge(bridgeSize);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movePosition, int index) {
        if (movePosition.equals(bridges.get(index))) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String inputGameCommand) {
        if (inputGameCommand.equals(Retry.RETRY.getMessage())) {
            return true;
        }
        return false;
    }

    public List<String> getBridges() {
        return bridges;
    }
}
