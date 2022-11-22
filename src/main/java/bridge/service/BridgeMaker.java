package bridge.service;

import bridge.Constants.CommandConstant;
import bridge.Constants.ErrorMessageConstant;
import bridge.util.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;


public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String path = designatePath(randomNumber);
            bridge.add(path);
        }
        return bridge;
    }

    private String designatePath(int randomNumber) {
        if (randomNumber == 0) {
            return CommandConstant.DOWN;
        }
        if(randomNumber == 1) {
            return CommandConstant.UP;
        }
        throw new IllegalArgumentException(ErrorMessageConstant.RANDOM_NUMBER_GENERATOR_OPERATION_FAILED);
    }
}
