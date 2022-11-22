package bridge.model;// @ author ninaaano

import bridge.view.MapView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MapMaker {
    private final StringBuilder upState = new StringBuilder();
    private final StringBuilder downState = new StringBuilder();

    private Queue<String> bridge;

    public MapMaker(List<String> bridge) {
        this.bridge = new LinkedList<>(bridge);
    }

    public void addMap(boolean answer) {
        if (upState.length() != 0 && downState.length() != 0) {
            upState.append(MapView.MAP_MIDDLE);
            downState.append(MapView.MAP_MIDDLE);
        }
        if (answer)
            addMapO(bridge.remove());
        if (!answer)
            addMapX(bridge.remove());

    }

    public void addMapO(String input) {
        if (input.equals("U")) {
            upState.append(MapView.MAP_O);
            downState.append(MapView.MAP_BLANK);
        }
        if (input.equals("D")) {
            upState.append(MapView.MAP_BLANK);
            downState.append(MapView.MAP_O);
        }
    }

    public void addMapX(String input) {
        if (input.equals("U")) {
            upState.append(MapView.MAP_BLANK);
            downState.append(MapView.MAP_X);
        }
        if (input.equals("D")) {
            upState.append(MapView.MAP_X);
            downState.append(MapView.MAP_BLANK);
        }
    }

    public List<String> printMap() {
        return List.of("[ " + upState + " ]", "[ " + downState + " ]");
    }

}
