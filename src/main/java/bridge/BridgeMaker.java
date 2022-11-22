package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private enum Direction{
        UP(1,"U"),
        DOWN(0,"D");

        private int num;
        private String word;
        Direction(int num, String word) {
            this.num = num;
            this.word = word;
        }
    }

    private final BridgeNumberGenerator bridgeNumberGenerator;
    
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
        int num = bridgeNumberGenerator.generate();
        if(num == Direction.UP.num){
            return Direction.UP.word;
        }
        return Direction.DOWN.word;
    }
}
