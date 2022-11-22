package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final String START = "[ ";
    private final String END = " ]";
    private final String MID = " | ";
    private final String CORRECT = "O";
    private final String MISS = "X";
    private final String BLANK = " ";

    private List<List<String>> bridgeMap;

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }
    public BridgeMap() {
        bridgeMap = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            bridgeMap.add(List.of(START,END));
        }
    }
    public void updateChooseUpper(boolean correct) {
        if (correct == true) {
            bridgeMap.get(0).add(bridgeMap.size() - 2 , CORRECT);
            bridgeMap.get(1).add(bridgeMap.size() - 2 , BLANK);
            return;
        }
        bridgeMap.get(0).add(bridgeMap.size() - 2 , MISS);
        bridgeMap.get(1).add(bridgeMap.size() - 2 , BLANK);
    }
    public void updateChooseLower(boolean correct) {
        if (correct == true) {
            bridgeMap.get(0).add(bridgeMap.size() - 2, BLANK);
            bridgeMap.get(1).add(bridgeMap.size() - 2, CORRECT);
            return;
        }
        bridgeMap.get(0).add(bridgeMap.size() - 2, BLANK);
        bridgeMap.get(1).add(bridgeMap.size() - 2, MISS);
    }
    public void updateMap(String choose, boolean correct) {
        if (choose == "U") {
            updateChooseUpper(correct);
            return;
        }
        updateChooseLower(correct);
    }

    public void refreshMap() {
        bridgeMap.clear();
        for (int i = 0; i < 2; i++) {
            bridgeMap.add(List.of(START,END));
        }
    }
}
