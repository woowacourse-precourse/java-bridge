package bridge.Model;

import java.util.List;

public class BridgeJudge {
    public boolean judgeInput(String userInput, List<String> bridge, int index) {
        return userInput.equals(bridge.get(index));
    }
}
