package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Bridge {
    private List<String> rounds;
    public Bridge(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        rounds = bridgeMaker.makeBridge(size);
    }

    public List<String> getRounds(){
        return rounds;
    }
}
