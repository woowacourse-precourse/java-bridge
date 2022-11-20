package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> output = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            int bridgeNumber = bridgeNumberGenerator.generate();
            output.add(getBridgeLaneText(bridgeNumber));
        }
        return output;
    }

    private String getBridgeLaneText(int number) {
        if(number == 0) {
            return "D";
        }
        if(number == 1) {
            return "U";
        }
        throw new IllegalArgumentException("다리를 생성할 때는 1 혹은 0의 숫자 중 하나를 이용해 생성합니다.");
    }
}
