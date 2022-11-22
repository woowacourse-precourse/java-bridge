package bridge;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final List<String> bridge = new ArrayList<>();


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

   
    public List<String> makeBridge(int size) {
        for (int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            bridge.add(checkUpOrDown(bridgeNumber));
        }
        return bridge;
    }

    private String checkUpOrDown(int number){
        if(number==0){
            return "D";
        }
        return "U";
    }
}
