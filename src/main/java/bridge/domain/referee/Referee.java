package bridge.domain.referee;

import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;

public class Referee {

    private final Bridge bridge;

    private Referee(Bridge bridge) {
        this.bridge = bridge;
    }

    public static Referee from(Bridge bridge) {
        return new Referee(bridge);
    }

    public Judgement checkDirection(Direction direction, int location) {
        return createJudgement(bridge.hasElementOf(direction, location));
    }

    private Judgement createJudgement(boolean judgement) {
        return new Judgement(judgement);
    }

    public boolean isEnd(int location) {
        return bridge.isEnd(location);
    }
}
