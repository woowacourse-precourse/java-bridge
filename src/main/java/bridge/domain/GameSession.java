package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameSession {

    private final List<String> bridge;
    private List<String> step;
    private int trial;

    public GameSession(List<String> bridge) {
        this.bridge = bridge;
        step = new ArrayList<>();
        this.trial = 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getTrial() {
        return trial;
    }

    public void addStep(String move) {
        step.add(move);
    }

    public boolean isMoveSuccess() {
        int index = step.size() - 1;
        return step.get(index).equals(bridge.get(index));
    }

    public List<String> getStep() {
        return step;
    }

    public void clearStep() {
        step.clear();
    }

    public boolean isArrived() {
        return step.size() == bridge.size();
    }

    public void addTrial() {
        this.trial++;
    }

    public void clearTrial() {
        this.trial = 0;
    }

}
