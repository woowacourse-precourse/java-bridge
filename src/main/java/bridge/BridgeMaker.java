package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    // TODO: 입력받은 사이즈 만큼의 다리를 생성한다.
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        while (bridge.size() < size)
            bridge.add(convertCorrectBridge());

        return bridge;
    }

    //TODO: bridgeNumberGenerator.generate() 값을 "U" 혹은 "D"로 변환하여 반환한다.
    private String convertCorrectBridge(){
        if (bridgeNumberGenerator.generate() == 1)
            return "U";
        return "D";
    }
}
