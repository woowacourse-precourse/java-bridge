package bridge;

import bridge.system.SystemValue;
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

    public List<String> makeBridge(int size) {
        List<String> newBridge = new ArrayList<>();

        for (int i = 0; i < size; i++){
            int randomNumber = bridgeNumberGenerator.generate();
            newBridge.add(expressUpAndDown(randomNumber));
        }

        return newBridge;
    }

    private String expressUpAndDown(int number){
        String result = "U";
        if (number == SystemValue.LOWER_CASE){
            return "D";
        }
        return result;
    }
}
