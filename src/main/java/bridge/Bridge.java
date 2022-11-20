package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridge = new ArrayList<>();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    Bridge(int size){
        bridge = bridgeMaker.makeBridge(size);
    }

    public void addBridge(String input){
        bridge.add(new String(input));
    }

    public String get(int idx){
        return bridge.get(idx);
    }

    public int size(){
        return bridge.size();
    }
}
