package bridge.game;

import bridge.status.PassOrNot;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    public static List<String> up = new ArrayList<>();
    public static List<String> down = new ArrayList<>();
    public static int tryNum = 1;
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public PassOrNot move(String input, int index) {
        if (bridge.get(index).equals(input)) {
            return PassOrNot.PASS;
        }
        return PassOrNot.NO_PASS;
    }

    public void retry() {
        up.clear();
        down.clear();
        tryNum++;
    }
}
