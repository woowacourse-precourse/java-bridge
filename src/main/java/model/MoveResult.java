package model;

public enum MoveResult {
    SUCCESS("O", true), FAIL("X", false);

    private String stringValue;
    private boolean succeed;

    MoveResult(String stringValue, boolean succeed) {
        this.stringValue = stringValue;
        this.succeed = succeed;
    }

    public String getStringValue() {
        return stringValue;
    }

    public boolean isSucceed() {
        return succeed;
    }
}
