package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    // 게임 시작 전 초기 다리 생성
    public UsersBridgeCrossStatus makeInitialBridge() {
        List<List<String>> newBridge = new ArrayList<>();
        newBridge.add(0, Arrays.asList("[", " ", " ", "]"));
        newBridge.add(1, Arrays.asList("[", " ", " ", "]"));
        return new UsersBridgeCrossStatus(newBridge);
    }

}
