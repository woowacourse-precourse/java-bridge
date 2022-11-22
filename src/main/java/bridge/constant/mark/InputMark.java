package bridge.constant.mark;

public enum InputMark {
    UP("U"),
    DOWN("D"),

    RETRY("R"),
    QUIT("Q");

    private String mark;

    InputMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
