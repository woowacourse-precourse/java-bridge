package bridge;

import static bridge.Moving.DOWN;
import static bridge.Moving.UP;
import static bridge.constant.BridgeSymbol.MOVING_EMPTY;
import static bridge.constant.BridgeSymbol.MOVING_O;
import static bridge.constant.BridgeSymbol.MOVING_X;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGame {

    private final List<String> bridge;
    private int round = 0;
    private int trialCount = 1;
    private boolean success = false;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean move(String moving) {
        increaseRound();
        String row = bridge.get(round - 1);
        boolean result = moving.equals(row);
        this.success = result;
        return result;
    }

    public void retry() {
        increaseTrialCount();
        resetGame();
    }

    private void increaseRound() {
        this.round += 1;
    }

    private void increaseTrialCount() {
        this.trialCount += 1;
    }

    private void resetGame() {
        this.round = 0;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getTrialCount() {
        return trialCount;
    }

    public Map<Moving, List<String>> getMap() {
        Map<Moving, List<String>> map = new HashMap<>();
        map.put(UP, new ArrayList<>());
        map.put(DOWN, new ArrayList<>());
        for (int i = 0; i < round - 1; i++) {
            cross(map, Moving.of(bridge.get(i)), true);
        }
        cross(map, Moving.of(bridge.get(round - 1)), success);
        return map;
    }
    
    private void cross(Map<Moving, List<String>> row, Moving moving, boolean isCorrectMoving) {
        Moving otherSide = getOtherSide(moving);
        if (isCorrectMoving) {
            row.get(otherSide).add(MOVING_EMPTY);
            row.get(moving).add(MOVING_O);
            return;
        }
        row.get(otherSide).add(MOVING_X);
        row.get(moving).add(MOVING_EMPTY);
    }

    private Moving getOtherSide(Moving moving) {
        return Moving.values()[(moving.ordinal() + 1) % 2];
    }

    public boolean isSuccess() {
        return success;
    }
}
