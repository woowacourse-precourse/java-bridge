package bridge.model;

import java.util.Arrays;
import java.util.List;

public enum SurviveAndDie {
    SURVIVE("O", List.of(true)),
    DIE("X", List.of(false)),
    NONE(" ", List.of(true, false));

    private final String display;
    private final List<Boolean> isSamePosition;

    SurviveAndDie(String display, List<Boolean> isSamePosition) {
        this.display = display;
        this.isSamePosition = isSamePosition;
    }

    public static SurviveAndDie from(boolean isSamePosition) {
        return Arrays.stream(SurviveAndDie.values())
                .filter(status -> status.isSamePosition.contains(isSamePosition))
                .findFirst()
                .orElse(null);
    }

    public boolean isDie() {
        return this == SurviveAndDie.DIE;
    }

    public String getDisplay(boolean isRightPlace) {
        if (isRightPlace) {
            return this.display;
        }
        return NONE.display;
    }
}