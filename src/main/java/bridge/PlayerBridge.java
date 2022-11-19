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

    public String makePlayerBridgeForm(){
        return makeBridgeForm(upBridge) +"\n"+makeBridgeForm(downBridge);
    }

    private static String makeBridgeForm(List<String> upList) {
        String val = "[";
        for (String s : upList) {
            val+=" " + s+" |";
        }
        val = val.substring(0, val.length()-1);
        val += "]";
        return val;
    }

    public boolean successRoot(){
        return !(upBridge.contains("X") || downBridge.contains("X"));
    }
}
