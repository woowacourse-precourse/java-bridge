package bridge.domain.bridgebuilder;

import bridge.domain.resources.UpOrDown;
import java.util.ArrayList;
import java.util.List;

public class BridgeConverter {

    public static List<String> createRealBridge(List<Integer> randomNums) {
        List<String> realBridge = new ArrayList<>();
        for (Integer num : randomNums) {
            realBridge.add(convertRandomNumToUD(num));
        }
        return realBridge;
    }

    public static String convertRandomNumToUD(int num) {
        if (num == 1) {
            return UpOrDown.UP;
        }
        return UpOrDown.DOWN;
    }
}
