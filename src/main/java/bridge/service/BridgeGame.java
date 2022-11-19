package bridge.service;

import java.util.List;

public class BridgeGame {

    public boolean move(String input, List<String> bridge, int idx) {
        if (bridge.get(idx).equals(input))
            return true;
        return false;
    }

    public boolean retry(String input) {
        if (input.equals("Q")) {
            return false;
        }
        return true;
    }
}
