package bridge.domain;

import java.util.List;

public class Bridges {
    private List<String> bridges;

    public void generate(List<String> bridges) {
        this.bridges = bridges;
    }

    public String getBridgeByPositionToMove(int position) {
        return bridges.get(position);
    }
}
