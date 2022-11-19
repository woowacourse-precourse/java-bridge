package bridge;

import bridge.domain.Bridge;
import bridge.domain.PlayersMove;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private PlayersMove playersMove;
    private int moveCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        playersMove = new PlayersMove();
        moveCount = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String choice) {
        playersMove.move(choice);
        moveCount++;
    }

    public List<Boolean> matchResults() {
        List<Boolean> matchRecord = new ArrayList<>(moveCount);
        for (int i = 0; i < moveCount; i++) {
            boolean match = isMatch(bridge.getBridgeMove(i), playersMove.getPlayersMoveAtIdx(i));
            matchRecord.add(match);
        }
        return matchRecord;
    }

    private boolean isMatch(String bridgeMove, String playersMove) {
        return bridgeMove.equals(playersMove);
    }

    public boolean lastMoveMatches() {
        return playersMove.lastMoveEquals(bridge.getBridgeMove(moveCount-1));
    }

    public boolean playerHasCrossed() {
        return moveCount == bridge.getBridgeSize();
    }

    public List<String> getPlayersMove() {
        return playersMove.getPlayersMove();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        refreshGameContext();
    }

    private void refreshGameContext() {
        playersMove.initialize();
        moveCount = 0;
    }
}
