package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Map {
    List<String> upperPath;
    List<String> lowerPath;

    public Map() {
        upperPath = new ArrayList<>();
        lowerPath = new ArrayList<>();
    }

    public void update(String direction, String answer) {
        String mark;
        if (direction.equals(answer)) {
            mark = Mark.PATH.getMark();
        } else {
            mark = Mark.BLOCK.getMark();
        }

        if (direction.equals(Direction.UP.toString())) {
            upperPath.add(mark);
            lowerPath.add(Mark.UNKNOWN.getMark());
        }
        if (direction.equals(Direction.DOWN.toString())) {
            upperPath.add(Mark.UNKNOWN.getMark());
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
