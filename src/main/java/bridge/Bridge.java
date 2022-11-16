package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridge = new ArrayList<>();

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean validateMove(String userDirection, int location) {
        if (bridge.get(location).equals(userDirection)) {
            return true;
        }

        return false;
    }
//
//    public long returnBridgeLength() { // 다리 길이 길것 대비하여 Long 사용
//        return bridge.size();
//    }
}
