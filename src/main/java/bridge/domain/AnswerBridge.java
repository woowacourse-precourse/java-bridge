package bridge.domain;

import bridge.constant.MovingDirection;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerBridge {

    private final List<MovingDirection> bridge;

    public AnswerBridge(List<String> bridges) {
        this.bridge = bridges.stream()
            .map(MovingDirection::from)
            .collect(Collectors.toList());
    }

    public MovingDirection getMovingDirection(int currentPosition) {
        return bridge.get(currentPosition);
    }

    public boolean isLastPosition(int currentPosition) {
        return currentPosition == bridge.size();
    }
}
