package bridge;

import bridge.utils.MapType;
import bridge.utils.Stairs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BridgeMap {
    public static final String START_BRACKET = "[";
    public static final String FINISH_BRACKET = "]";
    public static final String DIVIDING_LINE = "|";
    public static final String EMPTY_SPACE = "   ";
    private final Stack<String> upStairs = new Stack<>();
    private final Stack<String> downStairs = new Stack<>();

    public void make(MapType mapType) {
        mapInit();
        deleteFinishBracket();
        addDividingLine();
        pushValue(mapType);
        addFinishBracket();
    }

    private void addFinishBracket() {
        upStairs.add(FINISH_BRACKET);
        downStairs.add(FINISH_BRACKET);
    }

    public List<Stack> makeListToSend() {
        List<Stack> stairs = new ArrayList<>();
        stairs.add(upStairs);
        stairs.add(downStairs);
        return stairs;
    }

    private void addDividingLine() {
        if (upStairs.size() != 1 && downStairs.size() != 1) {
            upStairs.push(DIVIDING_LINE);
            downStairs.push(DIVIDING_LINE);
        }
    }

    private void pushValue(MapType mapType) {
        if (mapType.getStairs().equals(Stairs.UP_STAIRS.getAbbreviation())) {
            upStairs.push(mapType.getMapValue());
            downStairs.push(EMPTY_SPACE);
        }
        if (mapType.getStairs().equals(Stairs.DOWN_STAIRS.getAbbreviation())) {
            downStairs.push(mapType.getMapValue());
            upStairs.push(EMPTY_SPACE);
        }
    }

    private void deleteFinishBracket() {
        if (upStairs.peek().equals(FINISH_BRACKET) && downStairs.peek().equals(FINISH_BRACKET)) {
            upStairs.pop();
            downStairs.pop();
        }
    }

    private void mapInit() {
        if (upStairs.isEmpty() && downStairs.isEmpty()) {
            upStairs.push(START_BRACKET);
            downStairs.push(START_BRACKET);
        }
    }

    public void init() {
        upStairs.clear();
        downStairs.clear();
    }
}
