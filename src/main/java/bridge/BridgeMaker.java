package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    public List<String> makeBridge(int size) throws IllegalArgumentException{
        List<String> bridge = new ArrayList<>();
        int input = 0;

        for(int i = 0; i < size; i++){
            input = bridgeNumberGenerator.generate();
            bridge.add(BridgeCondition.findByInput(input).getDataValue());
        }

       return new ArrayList<>(bridge);
    }
}
