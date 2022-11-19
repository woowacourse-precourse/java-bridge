package bridge.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static List<String> bridge = new ArrayList<>();
    private static boolean canEdit = true;

    public Bridge(List<String> bridge) {
        if (Bridge.canEdit) {
            Bridge.bridge = bridge;
            Bridge.canEdit = false;
        }
    }

    public static boolean canCross(Integer space, String direction) {
        if (Bridge.canEdit) {
            throw new IllegalStateException("[ERROR] 다리가 생성되지 않았습니다.");
        }

        return bridge.get(space).equals(direction);
    }
}
