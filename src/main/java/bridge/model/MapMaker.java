package bridge.model;

import java.util.Stack;

public class MapMaker {
    private MapElement mapElement;
    private int index;


    public String buildMap(Stack<Direction> movement, Bridge bridge) {
        mapElement = new MapElement();
        initIndex();
        for (Direction direction : movement) {
            appendSeparator();
            appendBrokenBridge(bridge, direction);
            appendCorrectBridge(bridge, direction);
        }
        mapElement.appendEnd();
        return mapElement.getMap();
    }

    private void initIndex() {
        index = 0;
    }

    private void appendCorrectBridge(Bridge bridge, Direction direction) {
        if (bridge.isMoved(direction, index)) {
            mapElement.appendCross(direction);
            index++;
        }
    }

    private void appendBrokenBridge(Bridge bridge, Direction direction) {
        if (!bridge.isMoved(direction, index)) {
            mapElement.appendFail(direction);
        }
    }

    private void appendSeparator() {
        if (index > 0) {
            mapElement.appendSeparator();
        }
    }
}
