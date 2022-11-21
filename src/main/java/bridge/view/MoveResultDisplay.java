package bridge.view;

import bridge.domain.state.MoveResultState;

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
    
    public static List<MoveResultDisplay> convertToMoveResult(final List<MoveResultState> moveMoveResultStates) {
        return moveMoveResultStates.stream()
                .map(MoveResultDisplay::parseMoveResult)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private static MoveResultDisplay parseMoveResult(final MoveResultState moveResultState) {
        if (isStateFailed(moveResultState)) {
            return FAIL;
        }
        
        return SUCCESS;
    }
    
    private static boolean isStateFailed(final MoveResultState moveResultState) {
        return moveResultState.isMoveFailed();
    }
    
    public String getGameResult() {
        return gameResult;
    }
    
    public String getMovingResult() {
        return movingResult;
    }
}
