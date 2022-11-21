package bridge.engine;

import bridge.engine.reporter.BridgeResult;
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
    private int moveCount;
    private List<String> bridge;
    private List<String> userDirection;

    private BridgeState state;
    private BridgeStartState startState;
    private BridgeMoveState moveState;
    private BridgeRetryState retryState;

    public BridgeGame() {
        this.tryCount = 1;
        this.moveCount = 0;
        this.bridge = new ArrayList<>();
        this.userDirection = new ArrayList<>();
        this.state = new BridgeStartState(this);
        this.startState = new BridgeStartState(this);
        this.moveState = new BridgeMoveState(this);
        this.retryState = new BridgeRetryState(this);
    }

    public void start(int size) {
        state.start(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public boolean move(String direction) {
        return state.move(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public boolean retry(String command) {
        return state.retry(command);
    }

    /**
     * 브리지 게임을 종료할 때 사용하는 메서드
     */
    public BridgeResult end() {
        return state.end();
    }



    public int getTryCount() {
        return tryCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<String> getBridge() {return bridge;}

    public List<String> getUserDirection() {
        return userDirection;
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

    public void setState(BridgeState state) {
        this.state = state;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
}
