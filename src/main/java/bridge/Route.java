package bridge;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<String> up;
    private List<String> down;
    private String result;
    private int size;

    public Route() {
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
        this.result = "";
        this.size = 0;
    }

    public void goToNextBlock(String nextRoute, List<String> bridge) {
        result = compareRoute(nextRoute, bridge.get(size));
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

    public boolean gameSuccess(int bridgeSize) {
        if(this.size == bridgeSize && moveSuccess()) {
            return true;
        }
        return false;
    }


    public boolean moveSuccess() {
        if(result.equals("X")) {
            return false;
        }
        return true;
    }

    public String toString() {
        return up + "\n" + down;
    }
}
