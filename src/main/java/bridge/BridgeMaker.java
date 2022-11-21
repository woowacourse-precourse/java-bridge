package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    private static final int UP = 1;
    private static final String DOWN_DIRECTION = "D";
    private static final String UP_DIRECTION = "U";
    
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
            return UP_DIRECTION;
        }
        return DOWN_DIRECTION;
    }
}
