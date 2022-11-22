package repository;

import java.util.ArrayList;
import java.util.List;

public class BridgeRepository {
    private List<String> bridge;

    public void saveBridge(List<String> bridge) {
        this.bridge = bridge;
    }
}
