package bridge.game;

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
    private GameContext gameContext;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        playersMove = new PlayersMove();
        moveCount = 0;
        gameContext = new GameContext();
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
        for (int moveIdx = 0; moveIdx < moveCount; moveIdx++) {
            boolean match = isMatch(bridge.getBridgeMove(moveIdx), playersMove.getPlayersMoveAtIdx(moveIdx));
            matchRecord.add(match);
        }
        return matchRecord;
    }

    private boolean isMatch(String bridgeMove, String playersMove) {
        return bridgeMove.equals(playersMove);
    }

    public boolean lastMoveMatches() {
        int lastMoveIdx = moveCount - 1;
        return isMatch(bridge.getBridgeMove(lastMoveIdx), playersMove.getPlayersMoveAtIdx(lastMoveIdx));
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
        gameContext.increaseRetry();
    }

    private void refreshGameContext() {
        playersMove.initialize();
        moveCount = 0;
    }

    public void transitionTo(String cmd){
        gameContext.transition(cmd);
        if (onPlay()){
            retry();
        }
    }

    public boolean onPlay(){
        return gameContext.isPlaying();
    }

    public GameContext getContextInfo(){
        return gameContext;
    }
}
