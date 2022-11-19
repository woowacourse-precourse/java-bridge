package bridge.domain.referee;

import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;

public class Referee {

    public Judgement checkDirection(Bridge bridge, Direction direction, int location) {
        return createJudgement(bridge.hasElementOf(direction, location));
    }

    private Judgement createJudgement(boolean judgement) {
        return new Judgement(judgement);
    }
}
