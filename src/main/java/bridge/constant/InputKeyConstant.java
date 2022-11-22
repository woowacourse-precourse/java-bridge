package bridge.constant;

public enum InputKeyConstant {

    DOWN(0, "D"),
    UP(1, "U"),
    RETRY(-1, "R"),
    QUIT(-1, "Q");

    private final int code;
    private final String firstLetter;

    InputKeyConstant(int code, String firstLetter) {
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
