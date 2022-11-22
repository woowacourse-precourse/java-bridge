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

    /*브릿지 게임의 상태별 행동을 정의한 인터페이스*/
    private BridgeState state;

    /*이동 상태의 행위들을 정의함*/
    private BridgeMoveState moveState;

    /*재시도 상태의 행위들을 정의함*/
    private BridgeRetryState retryState;

    public BridgeGame() {
        this.tryCount = 1;
        this.moveCount = 0;
        this.bridge = new ArrayList<>();
        this.userDirection = new ArrayList<>();
        this.state = new BridgeStartState(this);
        this.moveState = new BridgeMoveState(this);
        this.retryState = new BridgeRetryState(this);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param size 생성할 다리의 사이즈
     */
    public void start(int size) {
        state.start(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param direction 위("U"), 아래("D")
     * @return 다리 칸 이동 성공 여부
     */
    public boolean move(String direction) {
        return state.move(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param command 재시도("R"), 종료("Q")
     * @return 재시도 여부
     */
    public boolean retry(String command) {
        return state.retry(command);
    }

    /**
     * 브리지 게임을 종료할 때 사용하는 메서드
     * @return 최종 다리 맵, 성공 여부, 시도 횟수 값을 담고 있는 객체
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
