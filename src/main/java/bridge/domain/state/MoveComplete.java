package bridge.domain.state;

import bridge.domain.Bridge;

public abstract class MoveComplete extends Started {
    private static final String MOVE_NOT_AVAILABLE = "[ERROR] 이미 다음 위치로 이동이 끝난 상황입니다.";
    
    private final String moving;
    
    MoveComplete(final Bridge bridge, final String moving) {
        super(bridge);
        this.moving = moving;
    }
    
    @Override
    public MoveResultState move(final int positionToMove, final String moving) {
        throw new IllegalStateException(MOVE_NOT_AVAILABLE);
    }
    
    @Override
    public String moving() {
        return moving;
    }
    
    @Override
    public String toString() {
        return " {bridge => " + bridge() + "moving => " + moving + "} ";
    }
}
