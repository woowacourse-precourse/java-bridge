package bridge.constant.mark;

public enum OutputMark {
    BEGIN_OF_BRIDGE("[ "),
    END_OF_BRIDGE(" ]"),
    DIVISION(" | "),

    BLANK(" ");

    private String mark;

    OutputMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
