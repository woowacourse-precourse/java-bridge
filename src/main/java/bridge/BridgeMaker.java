package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constant.Command.DOWN;
import static bridge.Constant.Command.UP;


public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> newBridge = new ArrayList<>();

        int number = 0;
        for(int i=0;i<size;i++) {
            number = bridgeNumberGenerator.generate();
            newBridge.add(number2bridge(number));
        }
        return newBridge;
    }

    private String number2bridge(int number){
        if(number == 0){
            return DOWN;
        }
        if(number == 1){
            return UP;
        }
        return null;
    }

}
