package bridge;

import java.util.*;

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

    public void addSuccess(String now) {
        if (now.equals("U")) {
            up.add("O");
            down.add(" ");
            return;
        }
        down.add("O");
        up.add(" ");
    }

    public void addFail(String now) {
        if (now.equals("U")) {
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
        if(up.toString().contains("X") || down.toString().contains("X")){
            return "실패";
        }
        return "성공";
    }

    public void reset() {
        init();
    }
}
