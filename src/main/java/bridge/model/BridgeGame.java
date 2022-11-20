package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridges;

    private BridgeGame(final List<String> bridges) {
        this.bridges = bridges;
    }

    public static BridgeGame of(final int number, BridgeNumberGenerator generator) {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        return new BridgeGame(bridgeMaker.makeBridge(number));
    }

    public List<String> move(final int currentPosition, final String command) {
        String currentAnswer = bridges.get(currentPosition);
        return BridgePosition.compare(currentAnswer, command);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<String> getBridges() {
        return this.bridges;
    }

    public boolean isSuccess(final List<String> result) {
        return BridgePosition.isSuccess(result);
    }
}
