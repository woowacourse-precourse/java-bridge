package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class RoundResult {

    private final String location;
    private final String status;


    public RoundResult(String location, String status) {
        this.location = location;
        this.status = status;
    }

    //key = up/down, value = status
    public Map<String,String> setUpandDown() {
        Map<String, String> upAndDown = new HashMap<>();
        if (isUp()) {
            upAndDown.put("up",this.status);
            upAndDown.put("down", " ");
            return upAndDown;
        }
        upAndDown.put("down",this.status);
        upAndDown.put("up", " ");
        return upAndDown;
    }

    private boolean isUp(){
        return this.location.equals("U");
    }

}
