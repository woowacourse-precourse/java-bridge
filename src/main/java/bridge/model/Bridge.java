package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridgeShape;
    private int size;

    public Bridge() {
        this.size = 0;
        this.bridgeShape = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public List<String> getBridgeShape() {
        return bridgeShape;
    }

    public void add(int number) {
        sizeUp();
        if (number == 1) {
            bridgeShape.add("U");
            return;
        }
        bridgeShape.add("D");
    }

    private void sizeUp() {
        size++;
    }
}
