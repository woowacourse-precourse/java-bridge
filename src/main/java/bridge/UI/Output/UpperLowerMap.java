package bridge.UI.Output;

import java.util.Map;

public class UpperLowerMap {
    public StringBuilder printUpperMap(Map<Integer, Map<String, String>> userStatus, String userSide) {
        StringBuilder upperSb = new StringBuilder();
        for (Integer turn : userStatus.keySet()) {
            if ((userStatus.get(turn)).keySet().stream().anyMatch(key -> key.equals(userSide))) {
                upperSb.append((userStatus.get(turn)).get(userSide));
                continue;
            }
            upperSb.append(" ");
        }
        return upperSb;
    }

}
