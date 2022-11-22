package bridge.constant;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Status {
    RIGHT_UPPER_SIDE("U", true),
    WRONG_UPPER_SIDE("U", false),
    RIGHT_LOWER_SIDE("D", true),
    WRONG_LOWER_SIDE("D", false);

    private final String currSelected;
    private final boolean isRight;

    Status(String currSelected, boolean isRight) {
        this.currSelected = currSelected;
        this.isRight = isRight;
    }

    public String getCurrSelected() {
        return currSelected;
    }

    public boolean getIsRight() {
        return isRight;
    }

    public static Status getStatus(String currSelected, boolean isRight) {
        return Arrays.stream(Status.values())
                .filter(status -> status.currSelected.equals(currSelected)
                        && status.isRight == isRight)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

}
