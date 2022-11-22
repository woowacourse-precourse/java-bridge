package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final String START = "[ ";
    private final String END = " ]";
    private final String MID = " | ";
    private final String CORRECT = "O";
    private final String MISS = "X";

    private List<List<String>> bridgeMap;

    public BridgeMap() {
        bridgeMap = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            bridgeMap.add(List.of(START,END));
        }
    }

    public void updateMap(List<String> bridge, int cursor, boolean correct) {

    }
}
