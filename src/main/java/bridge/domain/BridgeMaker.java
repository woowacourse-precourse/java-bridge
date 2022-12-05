package bridge.domain;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while(size != 0){
            bridge.add(generate());
            size -=1;
        }
        return bridge;
    }

    private String generate(){
        if(bridgeNumberGenerator.generate() == 1) return "U";
        return "D";
    }
}

