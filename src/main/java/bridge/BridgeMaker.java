package bridge;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    InputView inputView = new InputView();
    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }




    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<String>();
        int[] randomNumbers = new int[size];
        String input = inputView.getReadMoving();
        for(int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = bridgeNumberGenerator.generate();
            if(randomNumbers[i] == 1) {
                bridge.add("U");
            }
            if(randomNumbers[i] == 0) {
                bridge.add("D");
            }
        }
        return bridge;
    }
}
