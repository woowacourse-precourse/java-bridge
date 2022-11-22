package bridge.bridgeDomain.operator;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String>bridgeList= new ArrayList<>();
        for(int i=0;i<size;i++){
            int number = bridgeNumberGenerator.generate();
            bridgeList.add(convertBridge(number));
        }
        return Collections.unmodifiableList(bridgeList);
    }

    public String convertBridge(int number){
        if(number==1){
            return "U";
        }
        return "D";

    }

}
