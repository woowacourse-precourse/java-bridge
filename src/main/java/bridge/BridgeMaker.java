package bridge;

import java.util.List;
import java.util.ArrayList;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> crossable = new ArrayList<>();
        for (int index = 0; index<size; index++) {
            if (bridgeNumberGenerator.generate()==0) {
                crossable.add("D");
            } else if (bridgeNumberGenerator.generate()==0){
                crossable.add("U");
            }
         }
        return crossable;
    }

}
