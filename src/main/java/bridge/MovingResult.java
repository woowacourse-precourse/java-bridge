package bridge;

import java.util.Arrays;

public enum MovingResult {
    POSSIBLE("O", true),
    IMPOSSIBLE("X", false);

    private final String sign;
    private final boolean comparison;

    MovingResult(String sign, boolean comparison) {
        this.sign = sign;
        this.comparison = comparison;
    }

    public static MovingResult fromComparison(boolean comparison) {
        return Arrays.stream(MovingResult.values())
                .filter(movingResult -> movingResult.comparison == comparison)
                .findAny()
                .get();
    }

    public static MovingResult fromSign(String sign) {
        return Arrays.stream(MovingResult.values())
                .filter(movingResult -> movingResult.sign == sign)
                .findAny()
                .get();
    }

    public String getSign() {
        return sign;
    }

    public boolean getComparison() {
        return comparison;
    }
}
