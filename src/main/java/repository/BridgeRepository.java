package repository;

import java.util.ArrayList;
import java.util.List;

public class BridgeRepository {
    private List<String> bridge;
    private final List<String> progress = new ArrayList<>();

    public void saveBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void saveProgress(String direction) {
        progress.add(direction);
    }
}
