package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    private static final int UP = 1;
    
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }
    
    public List<String> makeBridge(int size) {
        List<String> answerBridge = new ArrayList<>();
        for(int i=0; i<size; i++){
            String direction = checkUpDown();
            answerBridge.add(direction);
        }
        return answerBridge;
    }

    private String checkUpDown() {
        int num;
        num = bridgeNumberGenerator.generate();
        if(num == UP){
            return "U";
        }
        return "D";
    }
}
