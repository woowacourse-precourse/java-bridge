package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    static final String ERROR_MESSAGE = "[ERROR]";

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

    public int getCounter() {
        return this.counter;
    }

    public int increaseCounter() {
        this.counter++;
        validateCounter(this.counter);
        return this.counter;
    }

    public boolean isO(int index) {
        if (this.bridge.get(index).equals(movings.get(index))) {
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        for (int i = 0; i < this.movings.size(); i++) {
            if (i == this.bridge.size() - 1) {
                return true;
            }
            if (!this.bridge.get(i).equals(movings.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void validateCounter(int counter) {
        if (counter >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "너무 많이 재시도했습니다.");
        }
    }
}
