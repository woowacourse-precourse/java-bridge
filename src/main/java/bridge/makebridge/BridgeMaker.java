package bridge.makebridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        String[] step = {"D", "U"};
        List<String> bridgeAnswer = new ArrayList<>();
        while (size-- > 0){
            int number = bridgeNumberGenerator.generate();
            bridgeAnswer.add(step[number]);
        }
        return (bridgeAnswer);
    }
}
