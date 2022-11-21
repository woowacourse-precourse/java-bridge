package bridge;

import java.util.ArrayList;
import java.util.List;

public class Draw {

    private List<String> upBridges = new ArrayList<>();
    private List<String> downBridges = new ArrayList<>();

    public void drawUpBridges(String symbol) {
        this.upBridges.add(symbol);
        this.downBridges.add(" ");
    }

    public void drawDownBridges(String symbol) {
        this.upBridges.add(" ");
        this.downBridges.add(symbol);
    }

    public List<String> getUpBridges() {
        return upBridges;
    }

    public List<String> getDownBridges() {
        return downBridges;
    }
}
