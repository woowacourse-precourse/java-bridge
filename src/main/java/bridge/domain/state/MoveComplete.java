package bridge.domain.state;

import java.util.List;

public abstract class MoveComplete extends Started {
    private static final String MOVE_NOT_AVAILABLE = "[ERROR] 이미 다음 위치로 이동이 끝난 상황입니다.";
    
    MoveComplete(final List<String> bridge) {
        super(bridge);
    }
    
    @Override
    public State move(final int currentPosition) {
        throw new IllegalStateException(MOVE_NOT_AVAILABLE);
    }
}
