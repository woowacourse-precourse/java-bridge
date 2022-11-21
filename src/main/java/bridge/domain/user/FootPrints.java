package bridge.domain.user;

import bridge.domain.enums.Direction;

public class FootPrints {

    private final FootPrint up;
    private final FootPrint down;

    public FootPrints() {
        up = new FootPrint();
        down = new FootPrint();
    }

    public void addStep(int status, Direction direction) {
        if (direction == Direction.UP) {
            up.addStep(status);
            down.addBlank();
            return;
        }
        up.addBlank();
        down.addStep(status);
    }

    public void reset() {
        up.clear();
        down.clear();
    }

    @Override
    public String toString() {
        return up.toString() + down.toString();
    }
}
