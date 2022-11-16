package bridge.domain.state;

import java.util.List;

public abstract class MoveComplete extends Started {
    MoveComplete(final List<String> bridge) {
        super(bridge);
    }
    
    @Override
    public State move(final int currentPosition) {
        throw new IllegalStateException("[ERROR] 이미 다음 위치로 이동이 끝난 상황입니다.");
    }
}
