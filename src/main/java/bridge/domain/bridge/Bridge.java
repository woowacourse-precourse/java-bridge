package bridge.domain.bridge;

import java.util.List;

public class Bridge {

    private int size;
    private List<String> bridges;
    private int currentLocation;

    public Bridge(int size, List<String> bridges) {
        this.size = size;
        this.bridges = bridges;
        this.currentLocation = 0;
    }

    public void updateLocation(String moving) {
        if (bridges.get(currentLocation) == moving) {
            currentLocation += 1;
        }
    }

}
