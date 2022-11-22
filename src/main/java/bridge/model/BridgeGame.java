package bridge.model;

import bridge.BridgeMaker;
import bridge. BridgeRandomNumberGenerator;
import static bridge.enums.Constant_BridgeGame.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGame {

    private final List<String> bridge;
    private Map<String, List<String>> progress = new HashMap<>();
    private int tryAttempt;

    public BridgeGame(int size) {
        this.tryAttempt = 0;
        retry();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public String result() {
        if (isFallBridge()) {
            return GAME_RESULT_LOSE.get();
        }

        return GAME_RESULT_WIN.get();
    }

    public void retry() {
        this.tryAttempt++;
        progress.put(UP_SIDE_PROGRESS.get(), new ArrayList<>());
        progress.put(DOWN_SIDE_PROGRESS.get(), new ArrayList<>());
    }

    public void move(String input) {
        int currentProgressSize = this.progress.get(UP_SIDE_PROGRESS.get()).size();
        String movingResult = compareMovableCell(input, currentProgressSize);

        if (input.equals(GAME_COMMAND_UP.get())) {
            addProgress(movingResult, UP_SIDE_PROGRESS.get(), DOWN_SIDE_PROGRESS.get());
        }
        if (input.equals(GAME_COMMAND_DOWN.get())) {
            addProgress(movingResult, DOWN_SIDE_PROGRESS.get(), UP_SIDE_PROGRESS.get());
        }
    }

    public boolean isContinue() {
        if (this.bridge.size() == this.progress.get(UP_SIDE_PROGRESS.get()).size()) {
            return false;
        }
        if (this.progress.get(UP_SIDE_PROGRESS.get()).contains(UNMOVABLE_CELL.get())) {
            return false;
        }
        if (this.progress.get(DOWN_SIDE_PROGRESS.get()).contains(UNMOVABLE_CELL.get())) {
            return false;
        }
        return true;
    }

    public boolean isFallBridge() {
        return this.progress.get(UP_SIDE_PROGRESS.get()).stream()
                .anyMatch(element -> element.equals(UNMOVABLE_CELL.get()))
                ||
                this.progress.get(DOWN_SIDE_PROGRESS.get()).stream()
                .anyMatch(element -> element.equals(UNMOVABLE_CELL.get()));
    }

    private String compareMovableCell(String input, int currentProgressSize) {
        String movingResult = new String();

        if (input.equals(this.bridge.get(currentProgressSize))) {
            movingResult =  MOVABLE_CELL.get();
        }
        if (!input.equals(this.bridge.get(currentProgressSize))) {
            movingResult =  UNMOVABLE_CELL.get();
        }

        return movingResult;
    }

    private void addProgress(String movingResult, String dest, String other) {
        this.progress.get(dest).add(movingResult);
        this.progress.get(other).add(BLANK_CELL.get());
    }

    public Map<String, List<String>> getProgress() {
        return this.progress;
    }

    public int getTryAttempt() {
        return this.tryAttempt;
    }
}
