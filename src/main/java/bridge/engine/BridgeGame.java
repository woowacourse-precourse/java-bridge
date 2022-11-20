package bridge.engine;

import bridge.engine.state.BridgeMoveState;
import bridge.engine.state.BridgeRetryState;
import bridge.engine.state.BridgeStartState;
import bridge.engine.state.BridgeState;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int tryCount;
    private List<String> bridge;
    private List<String> userDirection;

    private BridgeState state;
    private BridgeStartState startState;
    private BridgeMoveState moveState;
    private BridgeRetryState retryState;

    private BridgeGame(
            int tryCount,
            List<String> bridge,
            List<String> userDirection)
    {
        this.tryCount = tryCount;
        this.bridge = bridge;
        this.userDirection = userDirection;
        this.state = new BridgeStartState(this);
        this.startState = new BridgeStartState(this);
        this.moveState = new BridgeMoveState(this);
        this.retryState = new BridgeRetryState(this);
    }

    public static BridgeGame init() {
        return new BridgeGame(0, new ArrayList<>(), new ArrayList<>());
    }

    public void start() {
        boolean isMoving = true;
        state.start();

        while (isMoving && tryCount < bridge.size()) {
            boolean isSuccess = move();

            if (!isSuccess) {
                isMoving = retry();
            }
        }
        end();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public boolean move() {
        return state.move();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public boolean retry() {
        return state.retry();
    }

    public void end() {
        state.end();
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserDirection() {
        return userDirection;
    }

    public BridgeState getState() {
        return state;
    }

    public BridgeStartState getStartState() {
        return startState;
    }

    public BridgeMoveState getMoveState() {
        return moveState;
    }

    public BridgeRetryState getRetryState() {
        return retryState;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void setUserDirection(List<String> userDirection) {
        this.userDirection = userDirection;
    }

    public void setState(BridgeState state) {
        this.state = state;
    }
}
