package model.enums;

import java.util.Arrays;

public enum MoveResult {
    SUCCESS("O", true), FAIL("X", false), NULL(" ", null);

    private final String stringValue;
    private final Boolean succeed;

    MoveResult(String stringValue, Boolean succeed) {
        this.stringValue = stringValue;
        this.succeed = succeed;
    }

    public String getStringValue() {
        return stringValue;
    }

    public boolean succeed() {
        return succeed;
    }

    public static MoveResult getMatchResult(Boolean succeed) {
        return Arrays.stream(MoveResult.values()).filter((moveResult) -> moveResult.succeed == succeed)
                .findFirst()
                .get();
    }
}
