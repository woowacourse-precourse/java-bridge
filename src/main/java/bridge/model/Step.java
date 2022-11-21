package bridge.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

import static bridge.utils.ErrorMessage.INVALID_MOVING;

public enum Step {
    UP_SUCCESS(" O ", (safeZone, direction) -> safeZone.equals("U") && direction.equals("U")),
    UP_FAIL(" X ", (safeZone, direction) -> safeZone.equals("D") && direction.equals("U")),
    DOWN_SUCCESS(" O ", (safeZone, direction) -> safeZone.equals("D") && direction.equals("D")),
    DOWN_FAIL(" X ", (safeZone, direction) -> safeZone.equals("U") && direction.equals("D"));

    public final String value;
    private final BiPredicate<String, String> matchCase;

    Step(String value, BiPredicate<String, String> matchCase) {
        this.value = value;
        this.matchCase = matchCase;
    }

    public static Step of(String safeZone, String direction) {
        return Arrays.stream(values())
                .filter(trial -> trial.matchCase.test(safeZone, direction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MOVING.message));
    }
}
