package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class BridgeJudge {
    public void judgeInput(String userInput, String madeBridge, Bridge bridge) {
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        if(userInput.equals(madeBridge)) {
            if(userInput.equals("U")) {
                up.add("O");
                down.add(null);
            }
            if(userInput.equals("D")) {
                down.add("O");
                up.add(null);
            }
        }

        if(!userInput.equals(madeBridge)) {
            if(userInput.equals("U")) {
                up.add("X");
                down.add(null);
            }
            if(userInput.equals("D")) {
                down.add("X");
                up.add(null);
            }
        }
        bridge.setUp(up);
        bridge.setDown(down);
    }
}
