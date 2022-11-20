package bridge.repository;

import java.util.List;

public class BridgeRepository {

    private int size;
    private List<String> bridges;

    public BridgeRepository(int size) {
        this.size = size;
    }

    public void setBridges(List<String> bridges) {
        this.bridges = bridges;
    }
}
