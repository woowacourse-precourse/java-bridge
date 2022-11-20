package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private int size;
    private List<String> availableBridge;
    private List<String> upperBridge;
    private List<String> lowerBridge;
    private int position;
    private String lastResult;

    public Bridge(List<String> availableBridge, int size) {
        this.size = size;
        this.availableBridge = availableBridge;
        initBridge();
    }

    void initBridge () {
        this.upperBridge = new ArrayList<>(size);
        this.lowerBridge = new ArrayList<>(size);
        this.position = 0;
    }

    public boolean canMove(String moving) {
        return findMovablePosition().equals(moving);
    }

    private String findMovablePosition() {
        return availableBridge.get(position);
    }

    public void writeResult(String moving, String result) {
        writeUpperBridge(moving, result);
        writeLowerBridge(moving, result);
    }

    public void writeUpperBridge(String moving, String result) {
        if(moving.equals(Utils.UP_STRING)) {
            upperBridge.add(result);
            lowerBridge.add(Utils.BLANK);
        }
    }

    private void writeLowerBridge(String moving, String result) {
        if(moving.equals(Utils.DOWN_STRING)) {
            upperBridge.add(Utils.BLANK);
            lowerBridge.add(result);
        }
    }

    public void movePosition() {
        position++;
    }
}
