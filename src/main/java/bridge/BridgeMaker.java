package bridge;

import bridge.enums.Answer;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        while (bridge.size() != size) {
            bridge.add(Answer.markConvertAnswer(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private void validateSize(int size) {
        if (size < 3 || size > 20) {
            throw new IndexOutOfBoundsException();
        }
    }

}
