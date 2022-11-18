package bridge;

import java.util.List;

public class Judge {

    public boolean checkIsCorrectMoving(List<String> bridge, List<String> userBridge) {
        int compareIndex = userBridge.size() - 1;
        return bridge.get(compareIndex).equals(userBridge.get(compareIndex));
    }


}
