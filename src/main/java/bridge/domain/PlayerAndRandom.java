package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerAndRandom {

    public List<String> Judgment(String playerMoving, List<String> designBridge) {
        List<String> resultBridge = new ArrayList<>();

        for (String bridge : designBridge) {
            func(playerMoving, designBridge, resultBridge);
        }

        return resultBridge;
    }

    private void func(String playerMoving, List<String> designBridge, List<String> resultBridge) {
        if (playerMoving.equals(designBridge)) {
            resultBridge.add("O");
        }

        if (!(playerMoving.equals(designBridge))) {
            resultBridge.add("X");
        }
    }
}
