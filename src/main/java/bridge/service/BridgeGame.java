package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.User;

public class BridgeGame {
    private static final String RESTART_GAME = "R";
    private static final String QUIT_GAME = "Q";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, User user) {
        if (isUserPassedAllTurn(bridge)) {
            user.gameDoneWithWin();
        }
        bridge.nowIndexUpdate();
    }

    public boolean isUserPassedAllTurn(Bridge bridge) {
        if (bridge.isEndOfIndex()) {
            return true;
        }
        return false;
    }

    public void doFailCase(Bridge bridge, User user, String gameStatus) {
        if (gameStatus.equals(RESTART_GAME)) {
            retry(bridge, user);
        }
        if (gameStatus.equals(QUIT_GAME)) {
            user.gameDoneWithLose();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge, User user) {
        bridge.resetGame();
        user.gameRetry();
    }
}
