package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

    private static final String SUCCESS = "O";
    private static final String FAIL = "X";

    private int tryCount;
    private List<String> up;
    private List<String> down;

    public GameStatus() {
        tryCount = 1;
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void retry() {
        tryCount++;
        up.clear();
        down.clear();
    }

    public void move(Direction direction, boolean isSuccess) {
        if (direction.isUp()) {
            addStatus(up, isSuccess);
            return;
        }
        addStatus(down, isSuccess);
    }

    private void addStatus(List<String> bridge, boolean isSuccess) {
        if (isSuccess) {
            bridge.add(SUCCESS);
            return;
        }
        bridge.add(FAIL);
    }

    public String getBridgeStatus() {
        StringBuilder sb = new StringBuilder();
        makeMessage(sb, up);
        makeMessage(sb, down);

        return sb.toString();
    }

    private void makeMessage(StringBuilder sb, List<String> bridge) {
        sb.append("[ ");
        for (String status : up) {
            sb.append(status)
              .append(" | ");
        }
        sb.append(" ]")
          .append("\n");
    }

}
