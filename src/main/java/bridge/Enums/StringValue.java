package bridge.Enums;

public enum StringValue {

    QUIT("Q"),
    O("O"),
    X("X"),
    UP("U"),
    DOWN("D"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String stringValue;
    StringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getValue() {
        return stringValue;
    }

    public boolean isEqual(String word) {
        return stringValue.equals(word);
    }
}
