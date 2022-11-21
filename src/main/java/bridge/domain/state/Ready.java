package bridge.domain.state;

import bridge.domain.Bridge;

public class Ready extends Started {
    private static final String FAIL_CHECK_NOT_AVAILABLE = "[ERROR] 현재 상태에선 이동 성공 여부를 판단할 수 없습니다.";
    private static final String GAME_END_CHECK_NOT_AVAILABLE = "[ERROR] 현재 상태에선 게임 종료 여부를 판단할 수 없습니다.";
    private static final String MOVING_RETURN_NON_AVAILABLE = "[ERROR] 아직 이동하지 않아서 데이터가 없습니다.";
    
    public Ready(final Bridge bridge) {
        super(bridge);
    }
    
    @Override
    public MoveResultState move(final int positionToMove, final String moving) {
        if (isPartBridgeExist(positionToMove, moving)) {
            return new Success(bridge(), moving);
        }
        
        return new Fail(bridge(), moving);
    }
    
    private boolean isPartBridgeExist(final int positionToMove, final String moving) {
        return bridge().isPartBridgeExist(positionToMove, moving);
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
    public String moving() {
        throw new IllegalStateException(MOVING_RETURN_NON_AVAILABLE);
    }
}
