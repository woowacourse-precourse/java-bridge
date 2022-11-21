package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final String MARK_NOT_PATH = " ";
    List<String> upperPath;
    List<String> lowerPath;

    public Map() {
        upperPath = new ArrayList<>();
        lowerPath = new ArrayList<>();
    }

    public void update(String direction, String answer) {
        String mark;
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

    public List<String> getCurrentMap() {
        return List.of(makePathStringFormat(upperPath), makePathStringFormat(lowerPath));
    }

    private String makePathStringFormat(List<String> path) {
        return "[ " + String.join(" | ", path) + " ]";
    }
}
