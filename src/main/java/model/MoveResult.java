package model;

import java.util.Arrays;
import java.util.Optional;

public enum MoveResult {
    SUCCESS("O", true), FAIL("X", false), NULL(" ", null);

    private String stringValue;
    private Boolean succeed;

    MoveResult(String stringValue, Boolean succeed) {
        this.stringValue = stringValue;
        this.succeed = succeed;
    }

    public String getStringValue() {
        return stringValue;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public static MoveResult getMatchResult(Boolean succeed) {
        return Arrays.stream(MoveResult.values()).filter((moveResult) -> moveResult.succeed == succeed)
                .findFirst()
                .get();
    }
}
