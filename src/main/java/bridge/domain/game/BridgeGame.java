package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.direction.Direction;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.referee.Judgement;
import bridge.domain.referee.Referee;

public class BridgeGame {

    private final Referee referee;
    private int attempt;

    private BridgeGame(Referee referee) {
        this.attempt = 0;
        this.referee = referee;
    }

    public static BridgeGame from(Referee referee) {
        return new BridgeGame(referee);
    }

    public void move(Pedestrian pedestrian, Direction direction) {
        Judgement judgement = referee.checkDirection(direction, pedestrian.findLocation());
        pedestrian.move(judgement, direction);
    }

    public void retry(Pedestrian pedestrian) {
        pedestrian.clearRecord();
    }

    public int countRound() {
        return this.attempt += 1;
    }

    public boolean isSuccess(Pedestrian pedestrian) {
        return referee.isEnd(pedestrian.findLocation());
    }
}
