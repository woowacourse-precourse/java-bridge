package bridge.domain;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public final class BridgeGame {
    private final Bridge bridge;
    private BridgeVisited visited;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        retry();
    }
}