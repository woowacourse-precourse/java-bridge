package bridge.model;

import bridge.BridgeNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final int RETRY_DEFAULT_COUNT = 1;

    private final Bridges bridges;
    private Player player;
    private int retryCount;

    public BridgeGame(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridges = new Bridges(size, bridgeNumberGenerator);
        this.initNewPlayer();
        this.retryCount = RETRY_DEFAULT_COUNT;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Position position) {
        this.movePlayer(position);
        return this.isSuccessMove();
    }

    private void movePlayer(Position position) {
        this.player.move(position);
    }

    public boolean isSuccessMove() {
        return this.bridges.isSuccess(this.player);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.initNewPlayer();
        this.addRetryCount();
    }

    private void addRetryCount() {
        this.retryCount++;
    }

    private void initNewPlayer() {
        this.player = new Player();
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String printResult() {
        return this.player.printResult(isSuccessMove());
    }

    boolean isStartStatus() {
        return this.player.isStartStatus();
    }

    public boolean isCompletedGame() {
        return this.bridges.isCompletedGame(this.player);
    }
}
