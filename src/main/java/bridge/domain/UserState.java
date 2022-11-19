package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserState {
    private boolean quit;
    private int tryCount;
    private final List<String> upLine;
    private final List<String> downLine;

    public UserState() {
        this.quit = false;
        this.tryCount = 1;
        this.upLine = new ArrayList<>();
        this.downLine = new ArrayList<>();
    }

    public void quitChange() {
        quit = !quit;
    }

    public void tryCountIncrease() {
        tryCount++;
    }

    public boolean isQuit() {
        return quit;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getStep() {
        return upLine.size();
    }

    public String toString() {
        String up = makeLineOutput(upLine);
        String down = makeLineOutput(downLine);
        return up + "\n" + down;
    }

    private String makeLineOutput(List<String> line) {
        StringBuilder output = new StringBuilder("[");
        for (String c : line) {
            output.append(" ").append(c).append(" |");
        }
        output.replace(output.length() - 1, output.length(), "]");
        return String.valueOf(output);
    }
}
