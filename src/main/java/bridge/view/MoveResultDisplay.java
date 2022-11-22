package bridge.view;

import bridge.domain.state.MovingResultState;

import java.util.List;
import java.util.stream.Collectors;

public enum MoveResultDisplay {
    SUCCESS("성공", "O"),
    FAIL("실패", "X");
    
    private final String gameResult;
    private final String movingResult;
    
    MoveResultDisplay(final String gameResult, final String movingResult) {
        this.gameResult = gameResult;
        this.movingResult = movingResult;
    }
    
    public static List<MoveResultDisplay> convertToMoveResult(final List<MovingResultState> moveMovingResultStates) {
        return moveMovingResultStates.stream()
                .map(MoveResultDisplay::parseMoveResult)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private static MoveResultDisplay parseMoveResult(final MovingResultState movingResultState) {
        if (isStateFailed(movingResultState)) {
            return FAIL;
        }
        
        return SUCCESS;
    }
    
    private static boolean isStateFailed(final MovingResultState movingResultState) {
        return movingResultState.isMoveFailed();
    }
    
    public String getGameResult() {
        return gameResult;
    }
    
    public String getMovingResult() {
        return movingResult;
    }
}
