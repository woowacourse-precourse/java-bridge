package bridge.Domain;

import static bridge.Utils.Constants.BLANK;
import static bridge.Utils.Constants.DOWN;
import static bridge.Utils.Constants.UP;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private static final String MAP_START_PART = "[ ";
    private static final String MAP_MIDDLE_PART = " | ";
    private static final String MAP_END_PART = " ]";

    List<String> upMap;
    List<String> downMap;

    public BridgeMap() {
        upMap = new ArrayList<>();
        downMap = new ArrayList<>();
    }

    public void add(String upOrDown, String isCorrect) {
        if (upOrDown.equals(UP)) {
            upMap.add(isCorrect);
            downMap.add(BLANK);
        }
        if (upOrDown.equals(DOWN)) {
            upMap.add(BLANK);
            downMap.add(isCorrect);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(toStringAboutMap(upMap)).append("\n");
        builder.append(toStringAboutMap(downMap));
        return builder.toString();
    }

    private String toStringAboutMap(List<String> map) {
        StringBuilder builder = new StringBuilder();
        builder.append(MAP_START_PART);
        for (int i = 0; i < map.size() - 1; i++) {
            builder.append(map.get(i));
            builder.append(MAP_MIDDLE_PART);
        }
        builder.append(map.get(map.size() - 1));
        builder.append(MAP_END_PART);
        return builder.toString();
    }

    public void clear() {
        upMap.clear();
        downMap.clear();
    }
}
