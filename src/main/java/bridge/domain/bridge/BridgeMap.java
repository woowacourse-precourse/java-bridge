package bridge.domain.bridge;

import bridge.domain.Status;
import bridge.domain.Direction;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final List<List<String>> bridgeMap;

    public BridgeMap() {
        bridgeMap = new ArrayList<>() {
            {
                add(new ArrayList<>());
                add(new ArrayList<>());
            }
        };
    }

    public void add(String direction, boolean isCorrect) {
        int index = Direction.getBySymbol(direction).getKey();
        int otherIndex = getOtherIndex(index);
        String symbol = Status.getByStatus(isCorrect).getSymbol();

        bridgeMap.get(otherIndex).add(symbol);
        bridgeMap.get(index).add(" ");
    }

    private int getOtherIndex(int index) {
        List<Integer> indexes = new ArrayList<>(List.of(0, 1));
        indexes.remove(index);
        return indexes.get(0);
    }

    public List<List<String>> get() {
        return this.bridgeMap;
    }

}
