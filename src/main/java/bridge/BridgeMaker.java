package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridges = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int upOrDown = bridgeNumberGenerator.generate();
            bridges.add(UpOrDownAnswer(upOrDown));
        }
        return bridges;
    }

    private String UpOrDownAnswer(int upOrDown) {
        if(upOrDown == 1) return "U";
        return "D";
    }
}
