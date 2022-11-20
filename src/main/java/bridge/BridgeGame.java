package bridge;

import bridge.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private int tryCount = 1;
    private final List<String> correctBridge;
    private final List<List<String>> bridgeMap = new ArrayList<>();

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
        newBridgePattern();
    }

    public boolean checkMove(int bridgeNum, String moving) {
        String correctAnswer = correctBridge.get(bridgeNum);

        if (moving.equals(correctAnswer)) {
            mapIfCorrect(correctAnswer);
            return true;
        }
        mapIfWrong(correctAnswer);
        return false;
    }

    public List<List<String>> getBridgeMap() {
        return this.bridgeMap;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void retry() {
        newBridgePattern();
        this.tryCount += 1;
    }

    private void mapIfCorrect(String moving) {
        if (moving.equals("U")) {
            addMap(MapMark.CORRECT.mark(), MapMark.NOTHING.mark());
        }
        if (moving.equals("D")) {
            addMap(MapMark.NOTHING.mark(), MapMark.CORRECT.mark());
        }
    }

    private void mapIfWrong(String moving) {
        if (moving.equals("U")) {
            addMap(MapMark.WRONG.mark(), MapMark.NOTHING.mark());
        }
        if (moving.equals("D")) {
            addMap(MapMark.NOTHING.mark(), MapMark.WRONG.mark());
        }
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
