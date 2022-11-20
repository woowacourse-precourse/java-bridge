package bridge.domain.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerMap {

    private List<String> firstLine;
    private List<String> secondLine;

    public PlayerMap() {
        this.firstLine = new ArrayList<>();
        this.secondLine = new ArrayList<>();
    }

    public List<List> getPlayerMap() {
        return (List.of(firstLine, secondLine));
    }

    public int getSize() {
        return firstLine.size();
    }

    public void addResult(Moving moving, boolean value) {
        if (moving.equals("U")) {
            firstLine.add(getStatus(value));
            secondLine.add(" ");
        }
        if (moving.equals("D")) {
            firstLine.add(" ");
            secondLine.add(getStatus(value));
        }
    }

    private String getStatus(boolean value) {
        if (value) {
            return "O";
        }
        return "X";
    }
}
