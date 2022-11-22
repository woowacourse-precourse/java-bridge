package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserState {

    private final List<String> upLine;
    private final List<String> downLine;
    private int tryCount;

    public UserState() {
        this.tryCount = 0;
        this.upLine = new ArrayList<>();
        this.downLine = new ArrayList<>();
    }

    public void moveToUp(String moveResult) {
        upLine.add(moveResult);
        downLine.add(" ");
    }

    public void moveToDown(String moveResult) {
        downLine.add(moveResult);
        upLine.add(" ");
    }

    public boolean isSuccessOrFail(int bridgeSize) {
        int last = upLine.size() - 1;
        return upLine.size() == bridgeSize &&
                (upLine.get(last).equals("O") || downLine.get(last).equals("O"));
    }

    public void resetMove() {
        upLine.clear();
        downLine.clear();
    }

    public void tryCountIncrease() {
        tryCount++;
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
