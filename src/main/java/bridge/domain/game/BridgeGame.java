package bridge.domain.game;

import bridge.domain.direction.Direction;
import bridge.domain.pedestrian.Pedestrian;
import bridge.domain.referee.Judgement;
import bridge.domain.referee.Referee;

public class BridgeGame {

    private static final int MINIMUM_ROUND = 1;
    private static final int MAXIMUM_ROUND = 2_147_483_647;
    private final Referee referee;
    private int round;

    private BridgeGame(Referee referee) {
        this.referee = referee;
        this.round = MINIMUM_ROUND;
    }

    public static BridgeGame from(Referee referee) {
        return new BridgeGame(referee);
    }

    public void move(Pedestrian pedestrian, Direction direction) {
        Judgement judgement = referee.checkDirection(direction, pedestrian.findLocation());
        pedestrian.move(judgement, direction);
    }

    public void retry(Pedestrian pedestrian) {
        increaseRound();
        pedestrian.returnToStartPoint();
    }

    private void increaseRound() {
        validateRound(this.round);
        this.round++;
    }

    public Round createRound() {
        return new Round(this.round);
    }

    public boolean isEndLocation(Pedestrian pedestrian) {
        return referee.isEnd(pedestrian.findLocation());
    }

    private void validateRound(int number) {
        if (isEqualToMaximum(number)) {
            throw new IllegalArgumentException("[ERROR] 가능한 게임 라운드를 초과하였습니다.");
        }
    }

    private boolean isEqualToMaximum(int number) {
        return number == MAXIMUM_ROUND;
    }
}