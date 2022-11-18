package bridge.domain;

import bridge.dto.UserState;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private int userPosition;
    private boolean aliveUser;
    private boolean needToQuit;
    private int numberOfAttempts;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.userPosition = 0;
        this.aliveUser = true;
        this.needToQuit = false;
        this.numberOfAttempts = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        userPosition++;
        checkLife(direction);
    }

    public boolean isEndGame() {
        if (!aliveUser || bridge.isEndOfBridge(userPosition)) {
            return true;
        }
        return false;
    }

    public boolean isNeedToQuit() {
        if (bridge.isEndOfBridge(userPosition) && aliveUser) {
            needToQuit = true;
        }
        return needToQuit;
    }

    public UserState getProgressUserState() {
        return new UserState(bridge, userPosition, aliveUser);
    }

    private void checkLife(Direction direction) {
        if (!bridge.isCorrectDirection(direction, userPosition)) {
            aliveUser = false;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Command command) {
        if (command == Command.Restart) {
            settingForRestart();
        }
        if (command == Command.Quit) {
            settingForQuit();
        }
    }

    private void settingForRestart() {
        userPosition = 0;
        numberOfAttempts++;
        aliveUser = true;
    }

    private void settingForQuit() {
        needToQuit = true;
    }
}
