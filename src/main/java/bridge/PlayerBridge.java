package bridge;

import java.util.ArrayList;
import java.util.List;

public class PlayerBridge {

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    public void addUpRoot(String moving){
        upBridge.add(moving);
    }

    public void addDownRoot(String moving){
        downBridge.add(moving);
    }
}
