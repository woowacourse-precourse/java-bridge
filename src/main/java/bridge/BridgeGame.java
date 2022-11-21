package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constants.MapMark.*;
import static bridge.Constants.MoveMark.*;

public class BridgeGame {
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

    public void retry() {
        newBridgePattern();
    }

    private void mapIfCorrect(String moving) {
        if (moving.equals(UP.mark())) {
            addMap(CORRECT.mark(), NOTHING.mark());
        }
        if (moving.equals(DOWN.mark())) {
            addMap(NOTHING.mark(), CORRECT.mark());
        }
    }

    private void mapIfWrong(String moving) {
        if (moving.equals(UP.mark())) {
            addMap(WRONG.mark(), NOTHING.mark());
        }
        if (moving.equals(DOWN.mark())) {
            addMap(NOTHING.mark(), WRONG.mark());
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
