package bridge.domain;

import static bridge.domain.BridgeGameState.*;

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
    public void move(Moving moving) {
        checkMovable(moving);
        goForward(moving);
    }

    private void checkMovable(Moving moving) {
        if (moving.immovable(bridge.get(position))) {
            state = GAME_OVER;
        }
    }

    private void goForward(Moving moving) {
        position++;
        bridgeMap.update(moving, state);
        checkFinished();
    }

    private void checkFinished() {
        if (state != GAME_OVER && position == bridge.size()) {
            state = GAME_CLEAR;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        reset();
        increaseAttempts();
    }

    private void reset() {
        state = NORMAL;
        position = START_POSITION;
        bridgeMap.reset();
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
