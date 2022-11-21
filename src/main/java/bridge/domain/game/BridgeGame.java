package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.referee.Judgement;
import bridge.domain.referee.Referee;

public class BridgeGame {

    private final Bridge bridge;
    private int attempt;

    private BridgeGame(Bridge bridge) {
        this.attempt = 0;
        this.bridge = bridge;
    }

    public static BridgeGame from(Bridge bridge) {
        return new BridgeGame(bridge);
    }

    public void move(Pedestrian pedestrian, Direction direction) {
        Referee referee = new Referee();
        Judgement judgement = referee.checkDirection(bridge, direction, pedestrian.findLocation());
        pedestrian.move(judgement, direction);
    }

    public void retry(Pedestrian pedestrian) {
        pedestrian.clearRecord();
    }
}
