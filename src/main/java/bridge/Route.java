package bridge;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<String> up = new ArrayList<>();
    private List<String> down = new ArrayList<>();
    private int size = 0;

    public Route() {}

    public void goToNextBlock(String nextRoute, List<String> bridge) {
        String result = compareRoute(nextRoute, bridge.get(size));
        pointNextRoute(nextRoute, result);
        size++;
    }

    private String compareRoute(String nextRoute, String nextBlock) {
        if (nextRoute.equals(nextBlock)) {
            return "O";
        }
        return "X";
    }

    private void pointNextRoute(String nextRoute, String result) {
        if (nextRoute.equals("U")) {
            up.add(result);
            down.add(" ");
            return;
        }
        up.add(" ");
        down.add(result);
    }

    public List<String> getUp() {
        return this.up;
    }

    public List<String> getDown() {
        return this.down;
    }

    public String toString() {
        return up + "\n" + down;
    }
}
