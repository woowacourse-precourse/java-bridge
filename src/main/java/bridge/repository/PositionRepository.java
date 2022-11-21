package bridge.repository;

public class PositionRepository {

    public static final int INITIAL_POSITION_VALUE = 0;

    private int position;

    public PositionRepository() {
        this.position = INITIAL_POSITION_VALUE;
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        position++;
    }

    public boolean isEndPosition(final int bridgeSize) {
        return position == bridgeSize - 1;
    }

    public void initialize() {
        this.position = INITIAL_POSITION_VALUE;
    }
}
