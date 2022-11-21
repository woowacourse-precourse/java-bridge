package bridge;

import java.util.Arrays;

public enum MovingResult {
    POSSIBLE("O", true, "성공"),
    IMPOSSIBLE("X", false, "실패");

    private final String sign;
    private final boolean comparison;
    private final String phrase;

    MovingResult(String sign, boolean comparison, String phrase) {
        this.sign = sign;
        this.comparison = comparison;
        this.phrase = phrase;
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

    public String getPhrase() {
        return phrase;
    }
}
