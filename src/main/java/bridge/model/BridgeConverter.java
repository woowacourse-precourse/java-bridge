package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeConverter {

    public List<String> convertString(List<Integer> numberBridge) {
        List<String> bridge = new ArrayList<>();
        for (Integer number : numberBridge) {
            if (number == 1) {
                bridge.add("U");
            } else {
                bridge.add("D");
            }
        }
        return bridge;
    }
}
