package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final Player player = new Player();
    private Bridge bridge;

    public void createBridge(int bridgeSize) {
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move(Move moveTo) {
        if (player.move(bridge, moveTo)) {
            return GameStatus.PLAYING;
        }

        return GameStatus.FAIL;
    }

    public Map<Move, List<MoveResult>> getPlayerMoveResult() {
        return player.getMoveResults();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus retry(GameStatus gameStatus) {
        if (gameStatus == GameStatus.RETRY) {
            player.newLife();
            return GameStatus.PLAYING;
        }

        return GameStatus.QUIT;
    }
}
