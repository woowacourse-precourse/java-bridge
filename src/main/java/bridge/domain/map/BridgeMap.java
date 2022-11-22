package bridge.domain.map;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.map.BridgeMark.*;

public class BridgeMap {

    private static final String UP = "U";

    private final List<BridgeMark> upLine;
    private final List<BridgeMark> downLine;

    public BridgeMap() {
        upLine = new ArrayList<>();
        downLine = new ArrayList<>();

        init();
    }

    public void init() {
        upLine.clear();
        downLine.clear();

        upLine.add(START);
        downLine.add(START);
    }

    public void addResult(String direction, boolean result) {
        if (result) {
            addResult(direction, CORRECT);
            return;
        }
        addResult(direction, WRONG);
    }

    private void addResult(String direction, BridgeMark mark) {
        if (direction.equals(UP)) {
            addUp(mark);
            return;
        }
        addDown(mark);
    }

    private void addDown(BridgeMark mark) {
        addDelimiter();
        downLine.add(mark);
        upLine.add(BLANK);
    }

    private void addUp(BridgeMark mark) {
        addDelimiter();
        upLine.add(mark);
        downLine.add(BLANK);
    }

    private void addDelimiter() {
        upLine.add(DELIMITER);
        downLine.add(DELIMITER);
    }

    public List<BridgeMark> getUp() {
        ArrayList<BridgeMark> up = new ArrayList<>(upLine);
        up.add(END);
        return up;
    }

    public List<BridgeMark> getDown() {
        ArrayList<BridgeMark> down = new ArrayList<>(downLine);
        down.add(END);
        return down;
    }
}
