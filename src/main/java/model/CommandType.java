package model;

public enum CommandType {
    RETRY(true, "R"),
    QUIT(false, "Q");

    private final boolean run;
    private final String mark;

    CommandType(boolean run, String mark) {
        this.run = run;
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public boolean isEqualsMark(String mark) {
        return this.mark.equals(mark);
    }
}
