package bridge.Enum;

/* 유저가 U/D로 다리를 1칸 건넜을 때, 결과를 나타내는 상수입니다 */

public enum CrossResult {
    SUCCESS(true, "O"),
    FAIL(false, "X");

    private final boolean bool;
    private final String string;

    private CrossResult(boolean bool, String string) {
        this.bool = bool;
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
