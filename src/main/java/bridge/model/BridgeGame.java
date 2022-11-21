package bridge.model;

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
        player = new Player();
        retryCount = RETRY_DEFAULT_COUNT;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        int position = player.move(direction);
        return bridges.isRight(position, direction);
    }

    public boolean isCompletedGame() {
        return bridges.isCompletedGame(player);
    }

    public boolean isSuccess(){
        return bridges.isSuccess(player);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player = new Player();
        retryCount++;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public String printResult() {
        return player.printResult(isSuccess());
    }

    boolean isStartStatus() {
        return player.isStartStatus();
    }

}
