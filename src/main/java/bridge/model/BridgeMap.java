package bridge.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class BridgeMap {
    static final int SIZE_OF_TILES = 2;

    private ArrayList<LinkedList<String>> map;

    private BridgeMap(ArrayList<LinkedList<String>> map) {
        this.map = map;
    }

    public static BridgeMap generateMap() {
        ArrayList<LinkedList<String>> initializedMap = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_TILES; i++) {
            initializedMap.add(new LinkedList<String>());
        }
        return new BridgeMap(initializedMap);
    }

    public void insertMove(String moveResult, int order) {
        for (LinkedList<String> target : map) {
            target.add(" ");
        }
        LinkedList<String> target = map.get(order);
        target.set(target.size() - 1, moveResult);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<String> tiles : map) {
            sb.append("[ ");
            for (String tile : tiles) {
                sb.append(tile + " | ");
            }
            sb.replace(sb.length() - 3, sb.length(), " ]\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
