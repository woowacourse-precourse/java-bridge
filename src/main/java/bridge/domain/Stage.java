package bridge.domain;

public class Stage {

    private final int round;

    private final String direction;

    public Stage(final int round, final String direction) {
        this.round = round;
        this.direction = direction;
    }

    public PlayResult choose(final String direction) {
        return PlayResult.FAIL;
    }
}
