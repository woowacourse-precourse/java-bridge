package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<String> movableSpace;

    public Bridge(List<String> movableSpace){
        this.movableSpace = movableSpace;
    }

    public boolean checkMovable(int playerLocation, String selectedSpace) {
        return movableSpace.get(playerLocation).equals(selectedSpace);
    }

    public int getSize() {
        return movableSpace.size();
    }

    public List<String> getCurrentBridge(int playerLocation) {
        List<String> currentBridge = new ArrayList<>();
        for (int i = 0; i < playerLocation; i++) {
            currentBridge.add(movableSpace.get(i));
        }
        return currentBridge;
    }
}
