package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrectSpot(int checkIdx, String spot){
        if(bridge.get(checkIdx).equals(spot))
            return true;
        else
            return false;
    }
}
