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

    public void addSuccess(Bridge bridge) {
        if (bridge.getNow().equals("U")) {
            up.add("O");
            down.add(" ");
            return;
        }
        down.add("O");
        up.add(" ");
    }

    public void addFail(Bridge bridge) {
        if (bridge.getNow().equals("U")) {
            up.add(" ");
            down.add("X");
            return;
        }
        down.add(" ");
        up.add("X");
    }

    public StringJoiner getUp() {
        return up;
    }

    public StringJoiner getDown() {
        return down;
    }

    public String result() {
        return null;
    }
}
