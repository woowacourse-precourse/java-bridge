package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private Round round;

    public BridgeGame(int bridgeSize) {
        this.bridge = makeBridge(bridgeSize);
        this.round = new Round();
    }

    private Bridge makeBridge(int bridgeSize) {
        List<String> path = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        return new Bridge(path);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        round.updateStatusAfterMove(direction, bridge.getAccessibleIndexes(direction));
    }

    public String getPathResultToString() {
        List<String> courseResult = round.getCourseResult();
        return courseResult.get(0) + "\n" + courseResult.get(1);
    }

    public boolean isPlaying() {
        return round.isRoundPlaying(bridge.getDestinationIndex());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        round = new Round();
    }
}
