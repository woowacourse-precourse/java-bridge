package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final int TOP_SPACE = 1;
    private static final int UNDER_SPACE = 0;

    // 게임 시작 전 초기 다리 생성
    public UsersBridgeCrossStatus makeInitialBridge() {
        List<List<String>> newBridge = new ArrayList<>();
        newBridge.add(TOP_SPACE, Arrays.asList("[", " ", " ", "]"));
        newBridge.add(UNDER_SPACE, Arrays.asList("[", " ", " ", "]"));
        return new UsersBridgeCrossStatus(newBridge);
    }

}
