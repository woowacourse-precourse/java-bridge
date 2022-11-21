package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;
    private List<String> movings;
    private int counter;

    public Bridge(final int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
        this.movings = new ArrayList<>();
        this.counter = 1;
    }

    public boolean hasUAtIndex(final int index) {
        if (bridge.get(index).equals("U")) {
            return true;
        }
        return false;
    }

    public List<String> addMoving(final String moving) {
        movings.add(moving);
        return movings;
    }

    public List<String> getMovings() {
        return this.movings;
    }

    public int increaseCounter() {
        return this.counter++;
    }

    public boolean isO(final Bridge bridge, final List<String> movings, int index) {
        if (bridge.hasUAtIndex(index) & movings.get(index).equals("U")) {
            return true;
        }
        if (!bridge.hasUAtIndex(index) & movings.get(index).equals("D")) {
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        for (int i = 0; i < this.movings.size(); i++) {
            if (!this.bridge.get(i).equals(movings.get(i))) {
                return true;
            }
        }
        return false;
    }
}
