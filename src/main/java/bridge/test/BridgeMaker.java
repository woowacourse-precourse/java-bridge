package bridge.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> Bridge = new ArrayList<>();
        IntStream.range(0, size)
            .forEach(i -> Bridge.add(addBridge(bridgeNumberGenerator.generate())));
        return Bridge;
    }

    private String addBridge(int bridgenumber) {
        if (bridgenumber == 0) {
            return "D";
        }
        if (bridgenumber == 1) {
            return "U";
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");

    }
}
