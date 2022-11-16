package bridge.domain.state;

import java.util.List;

public abstract class MoveComplete extends Started {
    private static final String MOVE_NOT_AVAILABLE = "[ERROR] 이미 다음 위치로 이동이 끝난 상황입니다.";
    
    private final String moving;
    
    MoveComplete(final List<String> bridge, final String moving) {
        super(bridge);
        this.moving = moving;
    }
    
    @Override
    public State move(final int currentPosition, final String moving) {
        throw new IllegalStateException(MOVE_NOT_AVAILABLE);
    }
    
    public String moving() {
        return moving;
    }
}
