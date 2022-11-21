package bridge.Utils;

import java.util.List;

import static bridge.Enums.View.*;

public class Stringify {

    public String getPathToString(List<String> bridge, String position) {
        StringBuilder path = new StringBuilder();

        for (String block : bridge) {
            path.append(getBlockToString(block, position));
        }

        return path.toString();
    }

    private String getBlockToString(String block, String position) {
        if (block.equals(position)) {
            return SUCCESS.toString();
        }
        return BLANK.toString();
    }

    public String changeToFail(String path, String position, String direction) {
        if (position.equals(direction)) {
            return path + FAIL;
        }
        return path + BLANK;
    }

    public String getPathStringForUser(String upperPath, String lowerPath) {
        StringBuilder paths = new StringBuilder();

        paths.append(parseStringToUserView(upperPath));
        paths.append(parseStringToUserView(lowerPath));

        return paths.toString();
    }

    private String parseStringToUserView(String path) {
        return "[" + path.substring(1) + "]\n";
    }

}
