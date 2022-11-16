package bridge.domain.state;

import bridge.domain.Bridge;
import bridge.domain.MoveResult;

public class Ready extends Started {
    private static final String FAIL_CHECK_NOT_AVAILABLE = "[ERROR] 현재 상태에선 이동 성공 여부를 판단할 수 없습니다.";
    private static final String GAME_END_CHECK_NOT_AVAILABLE = "[ERROR] 현재 상태에선 게임 종료 여부를 판단할 수 없습니다.";
    private static final String STATE_RETURN_NOT_AVAILABLE = "[ERROR] 해당 위치의 준비 상태에선 상태를 알릴 필요가 없습니다.";
    
    public Ready(final Bridge bridge) {
        super(bridge);
    }
    
    @Override
    public State move(final int currentPosition, final String moving) {
        if (isPartBridgeExist(currentPosition, moving)) {
            return new Success(bridge(), moving);
        }
        
        return new Fail(bridge(), moving);
    }
    
    private boolean isPartBridgeExist(final int currentPosition, final String moving) {
        return bridge().isPartBridgeExist(currentPosition, moving);
    }
    
    @Override
    public boolean isMoveFailed() {
        throw new IllegalStateException(FAIL_CHECK_NOT_AVAILABLE);
    }
    
    @Override
    public boolean isGameFinished(final int numberOfMoves) {
        throw new IllegalStateException(GAME_END_CHECK_NOT_AVAILABLE);
    }
    
    @Override
    public MoveResult state() {
        throw new IllegalStateException(STATE_RETURN_NOT_AVAILABLE);
    }
}
