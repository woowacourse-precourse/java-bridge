package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {

    // TODO: refactoring
    private final List<String> up;
    private final List<String> down;

    public MoveResult() {
        up = new ArrayList<>();
        down = new ArrayList<>();
    }

    public void add(int status, String moveCommand) {
        if (moveCommand.equals("U")) {
            reflectStatus(status, up);
            down.add(" ");
            return;
        }
        reflectStatus(status, down);
        up.add(" ");
    }

    private void reflectStatus(int status, List<String> direction) {
        if (status != BridgeGame.DIED) {
            direction.add("O");
            return;
        }
        direction.add("X");
    }
}
