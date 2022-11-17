package bridge;

import java.util.List;

public class BridgeMakeHelper {
    public String decideBridgeAnswer(int number){
        if(number==1){
            return "U";
        }
        return "D";
    }

    public void appendBridge(List<String> bridge, String answer){
        bridge.add(answer);
    }
}
