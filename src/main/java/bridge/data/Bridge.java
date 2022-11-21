package bridge.data;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> saveBridge = new ArrayList<>();

    public Bridge (List<String> saveBridge) {
        this.saveBridge = saveBridge;
    }

    public boolean state(int order, String userInput) {
        return saveBridge.get(order).equals(userInput);
    }

    
}
