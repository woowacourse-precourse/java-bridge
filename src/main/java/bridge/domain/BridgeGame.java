package bridge.domain;

import bridge.state.BridgeGameState;
import bridge.state.ErrorState;
import bridge.state.RetryState;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private BridgeGameState bridgeGameState;
    private RetryState retryState;
    private int numOfGamePlayed;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.bridgeGameState = BridgeGameState.NORMAL;
        this.retryState = RetryState.START;
        this.numOfGamePlayed = 0;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public int getNumOfGamePlayed() {
        return numOfGamePlayed;
    }

    public BridgeGameState getBridgeGameState() {
        return bridgeGameState;
    }

    public RetryState getRetryState() {
        return retryState;
    }

    public void increaseNumOfGamePlayed() {
        this.numOfGamePlayed++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        this.bridgeGameState = bridge.move(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String readGameCommand) {
        if (readGameCommand.equals("R")) {
            this.bridge.init();
            this.bridgeGameState = BridgeGameState.NORMAL;
            this.retryState = RetryState.RETRY;
            return;
        }
        this.retryState = RetryState.QUIT;
    }
}
