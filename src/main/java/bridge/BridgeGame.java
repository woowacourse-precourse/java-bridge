package bridge;

import static bridge.BridgeGameState.*;

import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final int START_POSITION = 0;
    public static final int FIRST = 1;
    private final List<String> bridge;
    private final BridgeMap bridgeMap;
    private BridgeGameState state;
    private int position;
    private int attempt;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeMap = new BridgeMap();
        this.state = NORMAL;
        this.attempt = FIRST;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String selectedDirection) {
        checkMovable(bridge.get(position), selectedDirection);
        goForward();
        bridgeMap.update(selectedDirection, state);
        checkFinished();
    }

    private void checkMovable(String movableDirection, String selectedDirection) {
        if (notEquals(movableDirection, selectedDirection)) {
            state = GAME_OVER;
        }
    }

    private boolean notEquals(String operand1, String operand2) {
        return !operand1.equals(operand2);
    }

    private void goForward() {
        position++;
    }

    private void checkFinished() {
        if (state == GAME_OVER) {
            return;
        }
        if (position == bridge.size()) {
            state = GAME_CLEAR;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        resetState();
        resetPlayerPosition();
        bridgeMap.reset();
        increaseAttempts();
    }

    private void resetState() {
        state = NORMAL;
    }

    private void resetPlayerPosition() {
        position = START_POSITION;
    }

    private void increaseAttempts() {
        attempt++;
    }

    public boolean isNormal() {
        return state.equals(NORMAL);
    }

    public boolean isGameClear() {
        return state.equals(GAME_CLEAR);
    }

    public boolean isGameOver() {
        return state.equals(GAME_OVER);
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getAttempt() {
        return attempt;
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }
}
