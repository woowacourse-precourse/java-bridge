package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.referee.Judgement;
import bridge.domain.referee.Referee;

public class BridgeGame {

    private final Pedestrian pedestrian;
    private final Bridge bridge;

    private BridgeGame(Pedestrian pedestrian, Bridge bridge) {
        this.pedestrian = pedestrian;
        this.bridge = bridge;
    }

    public static BridgeGame of(Pedestrian pedestrian, Bridge bridge) {
        return new BridgeGame(pedestrian, bridge);
    }

    public void move(Direction direction) {
        Referee referee = new Referee();
        Judgement judgement = referee.checkDirection(bridge, direction, pedestrian.findLocation());
        pedestrian.move(judgement, direction);
    }

    public void retry() {
    }

}
