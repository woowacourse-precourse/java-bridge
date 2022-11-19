package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge = new ArrayList();

    public void init(){
        bridge = new ArrayList<>();
    }

    public void setBridge(int size){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    public List<String> getBridge(){
        return bridge;
    }
}
