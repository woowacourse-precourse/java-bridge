package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
final class BridgeGame {
    private final Bridge bridge;
    private Visited visited;

    BridgeGame(final Bridge bridge) {
        this.bridge = bridge;
        retry();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    void move(final Position nextPosition) {
        visited.move(nextPosition, bridge);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    void retry() {
        visited = new Visited();
    }

    boolean isFinish() {
        return !visited.isRemained(bridge);
    }

    GameResult result() {
        return visited.result(bridge);
    }

    String toPrintableLog() {
        return visited.toPrintableLog();
    }
}
