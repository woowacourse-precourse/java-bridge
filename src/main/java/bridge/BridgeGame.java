package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constants.MapMark.*;
import static bridge.Constants.MoveMark.*;

public class BridgeGame {
    private boolean isCorrect;
    private final List<List<String>> bridgeMap;

    public BridgeGame() {
        bridgeMap = new ArrayList<>();
        newBridgePattern();
    }

    public List<List<String>> move(int bridgeNum, String moving, List<String> correctBridge) {
        String correctAnswer = correctBridge.get(bridgeNum);
        isCorrect = moving.equals(correctAnswer);

        if (isCorrect)
            mapIfCorrect(moving);
        if (!isCorrect)
            mapIfWrong(moving);
        return this.bridgeMap;
    }

    public void retry() {
        newBridgePattern();
    }

    public boolean isCorrectMove() {
        return isCorrect;
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
