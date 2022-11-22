package bridge;

import java.util.ArrayList;
import java.util.List;

public class PlayerBridge {

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    public void addUpRootRight(){
        upBridge.add("O");
        downBridge.add(" ");
    }

    public void addDownRootRight(){
        downBridge.add("O");
        upBridge.add(" ");
    }

    public void addUpRootWrong(){
        upBridge.add("X");
        downBridge.add(" ");
    }

    public void addDownRootWrong(){
        downBridge.add("X");
        upBridge.add(" ");
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
