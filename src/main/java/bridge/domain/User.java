package bridge.domain;

import static bridge.utils.ErrorMessage.INVALID_INPUT_VALUE;

public class User {
    private int step = 0;
    private boolean live = true;
    private static final String UP_STARE = "U";
    private static final String DOWN_STARE = "D";

    public void init() {
        this.step = 0;
        this.live = true;
    }

    public void move(Bridge bridge, String input) {
        validateStatus(input);
        if (!bridge.isSafe(step, input)) {
            live = false;
            return;
        }
        step++;
    }

    private void validateStatus(String status) {
        if (isNotStatus(status)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    private boolean isNotStatus(String status) {
        return !UP_STARE.equals(status) && !DOWN_STARE.equals(status);
    }

    public int getStep() {
        return this.step;
    }

    public boolean isLive() {
        return this.live;
    }
}
