package bridge.utils;

import bridge.domain.state.State;
import bridge.exception.UtilClassCreateException;
import bridge.view.MoveResultDisplay;

import java.util.List;
import java.util.stream.Collectors;

public class MoveResultUtils {
    private MoveResultUtils() {
        throw new UtilClassCreateException();
    }
    
    public static List<MoveResultDisplay> convertToMoveResult(final List<State> moveStates) {
        return moveStates.stream()
                .map(MoveResultUtils::parseMoveResult)
                .collect(Collectors.toUnmodifiableList());
    }
    
    private static MoveResultDisplay parseMoveResult(final State state) {
        if (isStateFailed(state)) {
            return MoveResultDisplay.FAIL;
        }
        
        return MoveResultDisplay.SUCCESS;
    }
    
    private static boolean isStateFailed(final State state) {
        return state.isMoveFailed();
    }
}
