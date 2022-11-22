package bridge.domain;

import bridge.dto.GameResult;
import bridge.dto.UserState;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private User user;
    private boolean needToQuit;
    private int numberOfAttempts;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.user = new User(bridge);
        this.needToQuit = false;
        this.numberOfAttempts = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        user.move(direction);
    }

    public boolean isEndGame() {
        if (!user.isAlive() || successGame()) {
            return true;
        }
        return false;
    }

    public boolean isNeedToQuit() {
        if (successGame()) {
            needToQuit = true;
        }
        return needToQuit;
    }

    public UserState getProgressUserState() {
        return user.getUserState();
    }

    public GameResult getGameResult() {
        return new GameResult(user.getUserState(), successGame(), numberOfAttempts);
    }

    private boolean successGame() {
        if (user.reachEndOfBridge() && user.isAlive()) {
            return true;
        }
        return false;
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
        user.revive();
        numberOfAttempts++;
    }

    private void settingForQuit() {
        needToQuit = true;
    }
}
