package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private int tryCount = 1;
    private final String CORRECT = "O";
    private final String WRONG = "X";
    private final String NOTHING = " ";
    private final List<String> correctBridge;
    private final List<List<String>> bridgeMap = new ArrayList<>();

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
        newBridgePattern();
    }

    public boolean checkMove(int bridgeNum, String moving) {
        String correctAnswer = correctBridge.get(bridgeNum);
        if (moving.equals(correctAnswer)) {
            if (moving.equals("U")) addMap(CORRECT, NOTHING);
            if (moving.equals("D")) addMap(NOTHING, CORRECT);
            return true;
        }
        if (moving.equals("U")) addMap(WRONG, NOTHING);
        if (moving.equals("D")) addMap(NOTHING, WRONG);
        return false;
    }

    public List<List<String>> getBridgeMap() {
        return this.bridgeMap;
    }

    public int retry() {
        newBridgePattern();
        this.tryCount += 1;
        return tryCount;
    }

    private void newBridgePattern() {
        this.bridgeMap.clear();
        for (int i = 0; i < 2; i++) {
            this.bridgeMap.add(new ArrayList<>());
        }
    }

    private void addMap(String mapUp, String mapDown) {
        this.bridgeMap.get(0).add(mapUp);
        this.bridgeMap.get(1).add(mapDown);
    }
}
