package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameStatus {

    private static final String O = "O";
    private static final String X = "X";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private boolean isFail;
    private int tryCount;
    private final List<String> up;
    private final List<String> down;

    public GameStatus() {
        tryCount = 1;
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public String getStatus() {
        if (isFail) {
            return FAIL;
        }
        return SUCCESS;
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
            bridge.add(O);
            return;
        }
        bridge.add(X);
        this.isFail = true;
    }

    public String getBridgeStatus() {
        StringBuilder sb = new StringBuilder();
        makeMessage(sb, up);
        makeMessage(sb, down);

        return sb.toString();
    }

    private void makeMessage(StringBuilder sb, List<String> bridge) {
        sb.append("[ ");
        for (String status : bridge) {
            sb.append(status)
              .append(" | ");
        }
        sb.append(" ]")
          .append("\n");
    }

}
