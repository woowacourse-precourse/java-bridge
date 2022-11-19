package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeLog {
    private final List<List<String>> map;

    public BridgeLog(List<String> bridgeLine, List<String> userCrossLog) {
        this.map = List.of(new ArrayList<>(), new ArrayList<>());
        buildinBridgeLog(bridgeLine, userCrossLog);
    }

    private void buildinBridgeLog(List<String> bridgeLine, List<String> userCrossLog) {
        for (int index = 0; index < userCrossLog.size(); index++) {
            map.get(0).add(" ");
            map.get(1).add(" ");

            int wentUserPlace = wentUserPlace(userCrossLog.get(index));
            String moveResult = moveResult(bridgeLine.get(index), userCrossLog.get(index));
            map.get(wentUserPlace).set(index, moveResult);
        }
    }

    private String moveResult(String str1, String str2) {
        if (str1.equals(str2)) {
            return "O";
        }
        return "X";
    }

    private int wentUserPlace(String moveKey) {
        if (moveKey.equals(GameKeySet.UP.getKeySet())) {
            return 0;
        }
        return 1;
    }

    public List<List<String>> getMap() {
        return map;
    }

    public List<String> getMap(int index) {
        return map.get(index);
    }


}
