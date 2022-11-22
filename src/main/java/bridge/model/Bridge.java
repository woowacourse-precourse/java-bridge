package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridgeShape;
    private int size;

    public Bridge(List<String> bridgeShape) {
        this.size = 0;
        this.bridgeShape = new ArrayList<>();
        for (String value : bridgeShape) {
            this.bridgeShape.add(value);
        }
        this.size = this.bridgeShape.size();
    }

    public int getSize() {
        return size;
    }

    public List<String> getBridgeShape() {
        return bridgeShape;
    }

    public boolean bridgeSameIndex(int index, String upDown) {
        return bridgeShape.get(index).equals(upDown);
    }

//    public void add(String number) {
//        sizeUp();
//        if (number.equals("1")) {
//            bridgeShape.add("U");
//            return;
//        }
//        bridgeShape.add("D");
//    }

    private void sizeUp() {
        size++;
    }
}
