package bridge;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final String MARK_NOT_PATH = " ";
    List<String> bridge;
    List<String> upperPath;
    List<String> lowerPath;

    public Map(List<String> bridge) {
        this.bridge = bridge;
        upperPath = new ArrayList<>(bridge.size());
        lowerPath = new ArrayList<>(bridge.size());
    }

    public void update(String direction) {
        String mark;
        String answer = bridge.get(upperPath.size());
        if (direction.equals(answer)) {
            mark = "O";
        } else {
            mark = "X";
        }

        if (direction.equals("U")) {
            upperPath.add(mark);
            lowerPath.add(MARK_NOT_PATH);
        }
        if (direction.equals("D")) {
            upperPath.add(MARK_NOT_PATH);
            lowerPath.add(mark);
        }
    }

    public String getPath(String flag) {
        if (flag.equals("U")) {
            return makePathStringFormat(upperPath);
        }
        if (flag.equals("D")) {
            return makePathStringFormat(lowerPath);
        }
        return "";
    }

    private String makePathStringFormat(List<String> path) {
        return "[ " + String.join(" | ", path) + " ]";
    }
}
