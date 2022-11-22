package bridge.model;

import bridge.standard.Rule;

import java.util.Arrays;

public enum Stage {
    CROSS(true, Rule.CORRECT_MARK, ""),
    CAN_NOT_CROSS(false, Rule.WRONG_MARK, Rule.STAGE_FAIL),
    NONE(false, "-", "오류");

    private final boolean isMatch;
    private final String mark;
    private final String outcome;

    Stage(boolean isMatch, String mark, String outcome) {
        this.isMatch = isMatch;
        this.mark = mark;
        this.outcome = outcome;
    }

    public static Stage judge(boolean isMatch) {
        return Arrays.stream(Stage.values())
                .filter(Stage1 -> Stage1.isMatch == isMatch)
                .findAny()
                .orElse(NONE);
    }

    public String getOutcome() {
        return outcome;
    }
    public String getMark() {
        return mark;
    }
}