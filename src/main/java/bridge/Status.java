package bridge;

import java.util.StringJoiner;

public class Status {
    private StringJoiner up;
    private StringJoiner down;

    public Status() {
        init();
    }

    private void init() {
        this.up = new StringJoiner(" | ");
        this.down = new StringJoiner(" | ");
    }

    public StringJoiner getUp() {
        return null;
    }

    public StringJoiner getDown() {
        return null;
    }

    public String result() {
        return null;
    }
}
