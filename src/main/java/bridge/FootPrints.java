package bridge;

import java.util.ArrayList;
import java.util.List;

public class FootPrints {

    // TODO: refactoring
    private final List<String> up;
    private final List<String> down;

    public FootPrints() {
        up = new ArrayList<>();
        down = new ArrayList<>();
    }

    public void add(int status, String direction) {
        if (direction.equals("U")) {
            reflectStatus(status, up);
            down.add(" ");
            return;
        }
        reflectStatus(status, down);
        up.add(" ");
    }

    private void reflectStatus(int status, List<String> footPrint) {
        if (status != BridgeGame.LOSE) {
            footPrint.add("O");
            return;
        }
        footPrint.add("X");
    }

    @Override
    public String toString() {
        return String.format("[ %s ]\n[ %s ]\n", String.join(" | ", up), String.join(" | ", down));
    }
}
