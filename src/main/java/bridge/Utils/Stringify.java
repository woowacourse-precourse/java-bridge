package bridge.Utils;

import java.util.List;

import static bridge.Enums.View.*;

public class Stringify {

    public String getPathToString(List<String> bridge, String position) {
        StringBuilder result = new StringBuilder();

        if(bridge.isEmpty()) {
            return result.toString();
        }

        for (String block : bridge) {
            result.append(getBlockToString(block, position));
        }

        return result.toString();
    }

    public String changeToFail(String path, String position, String direction) {
        if (position.equals(direction)) {
            return path + FAIL;
        }
        return path + BLANK;
    }

    private String getBlockToString(String block, String position) {
        if (block.equals(position)) {
            return SUCCESS.toString();
        }
        return BLANK.toString();
    }


}
