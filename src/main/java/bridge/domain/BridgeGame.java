package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Game;
import bridge.BridgeRandomNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, Game game, String userMove) {
        if (bridge.isSameValueOfComputerAndUser(userMove)) {
            checkEndPoint(bridge, game);
        }
    }

    public void checkEndPoint(Bridge bridge, Game game) {
        if (bridge.isEndPoint()) {
            endGameWithWin(game);
            return;
        }
        bridge.nextIndex();
    }

    public void endGameWithWin(Game game) {
        game.winGame();
        game.GameDone();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge, Game game) {
        bridge.resetIndex();
        game.restartGame();
    }


}
