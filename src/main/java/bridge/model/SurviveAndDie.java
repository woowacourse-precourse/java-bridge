package bridge.model;

import java.util.Arrays;

public enum SurviveAndDie {
    SURVIVE("O", true),
    DIE("X", false);

    private final String display;
    private final boolean isSamePosition;

    SurviveAndDie(String display, boolean isSamePosition) {
        this.display = display;
        this.isSamePosition = isSamePosition;
    }

    public static SurviveAndDie from(boolean isSamePosition) {
        return Arrays.stream(SurviveAndDie.values())
                .filter(status -> status.isSamePosition == isSamePosition)
                .findFirst()
                .orElse(null);
    }

    public static String getDisplay(SurviveAndDie surviveAndDie) {
        return surviveAndDie.display;
    }
    public static boolean isDie(SurviveAndDie surviveAndDie){
        return surviveAndDie == SurviveAndDie.DIE;
    }

}