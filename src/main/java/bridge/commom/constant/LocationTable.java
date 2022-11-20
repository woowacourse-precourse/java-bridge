package bridge.commom.constant;

import java.util.List;
import java.util.Map;

public class LocationTable {
    private static final Map<String, Integer> locationMap = Map.of(
            "D", 0,
            "U", 1
    );
    private static final List<String> locationList = List.of("D", "U");

    public static int getIndexWithKey(String key) {
        return locationMap.get(key);
    }

    public static String getKeyWithIndex(int index) {
        return locationList.get(index);
    }

}
