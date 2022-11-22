package bridge.domain;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public final class BridgeGame {
    private final Bridge bridge;
    private BridgeVisited visited;

    private BridgeGame(final Bridge bridge) {
        this.bridge = bridge;
        retry();
    }
    public static BridgeGame of (final Bridge bridge){
        return new BridgeGame(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final BridgeGamePosition next) {
        visited.move(next, bridge);
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        visited = new BridgeVisited();
    }

    public boolean isFinish() {
        return !visited.isRemained(bridge);
    }

    public BridgeGameResult result() {
        return visited.result(bridge);
    }

    public String printMoveInfo() {
        return visited.printMoveInfo();
    }
}