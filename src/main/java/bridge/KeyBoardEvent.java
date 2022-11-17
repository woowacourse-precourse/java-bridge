package bridge;

public enum KeyBoardEvent {

    DOWN(0, "D"),
    UP(1, "U");

    private final int code;
    private final String firstLetter;

    KeyBoardEvent(int code, String firstLetter) {
        this.code = code;
        this.firstLetter = firstLetter;
    }

    public int getCode() {
        return code;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}
