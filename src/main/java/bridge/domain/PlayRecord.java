package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayRecord {
    private int stageCount;
    private final List<String> upPlayingBridge;
    private final List<String> downPlayingBridge;

    public PlayRecord() {
        this.stageCount = 0;
        this.upPlayingBridge = new ArrayList<>();
        this.downPlayingBridge = new ArrayList<>();
    }

    public List<List<String>> getPlayingBridge() {
        return List.of(downPlayingBridge, upPlayingBridge);
    }

    public int getStageCount() {
        return this.stageCount;
    }

    public void increaseGameCount() {
        stageCount++;
    }

    public void failCrossingBridge(String moving) {
        if (moving.equals("U")) {
            upPlayingBridge.add("X");
            downPlayingBridge.add(" ");
        }
        if (moving.equals("D")) {
            upPlayingBridge.add(" ");
            downPlayingBridge.add("X");
        }
    }

    public void successCrossingBridge(String moving) {
        if (moving.equals("U")) {
            upPlayingBridge.add("O");
            downPlayingBridge.add(" ");
        }
        if (moving.equals("D")) {
            upPlayingBridge.add(" ");
            downPlayingBridge.add("O");
        }
    }

    public void initialize() {
        upPlayingBridge.clear();
        downPlayingBridge.clear();
    }
}
