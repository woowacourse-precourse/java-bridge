package bridge;

import bridge.utils.MapType;
import bridge.utils.Stairs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BridgeMap {
    private final Stack<String> upStairs = new Stack<>();
    private final Stack<String> downStairs = new Stack<>();

    public void make(MapType mapType) {
        mapInit();
        deleteFinishBracket();
        addDividingLine();
        System.out.println(mapType.name());
        pushValue(mapType);
        addFinishBracket();
    }

    private void addFinishBracket() {
        upStairs.add("]");
        downStairs.add("]");
    }

    public List<Stack> makeListToSend() {
        List<Stack> stairs = new ArrayList<>();
        stairs.add(upStairs);
        stairs.add(downStairs);
        return stairs;
    }

    private void addDividingLine() {
        if (upStairs.size() != 1 && downStairs.size() != 1) {
            upStairs.push("|");
            downStairs.push("|");
        }
    }

    private void pushValue(MapType mapType) {
        if (mapType.getStairs().equals(Stairs.UP_STAIRS.getAbbreviation())) {
            upStairs.push(mapType.getMapValue());
            downStairs.push("   ");
        }
        if (mapType.getStairs().equals(Stairs.DOWN_STAIRS.getAbbreviation())) {
            downStairs.push(mapType.getMapValue());
            upStairs.push("   ");
        }
    }

    private void deleteFinishBracket() {
        if (upStairs.peek().equals("]") && downStairs.peek().equals("]")) {
            upStairs.pop();
            downStairs.pop();
        }
    }

    private void mapInit() {
        if (upStairs.isEmpty() && downStairs.isEmpty()) {
            upStairs.push("[");
            downStairs.push("[");
        }
    }
}
