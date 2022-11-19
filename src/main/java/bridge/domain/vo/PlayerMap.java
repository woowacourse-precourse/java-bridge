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

    public void addResult(String place, boolean value) {
        if (place.equals("U")) {
            firstLine.add(getStatus(value));
            secondLine.add(" ");
        }
        if (place.equals("D")) {
            firstLine.add(" ");
            secondLine.add(getStatus(value));
        }
    }

    public boolean checkContainsX() {
        return !firstLine.contains("X") == secondLine.contains("X");
    }

    private String getStatus(boolean value) {
        if (value) {
            return "O";
        }
        return "X";
    }
}
